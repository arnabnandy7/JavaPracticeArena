package practise.Patterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingletonPatternSolution implements Serializable, Cloneable {
	private static volatile SingletonPatternSolution soleInstance = null;

	private SingletonPatternSolution() {
		if (soleInstance != null) {
			throw new RuntimeException(
					"Cannot create, please use getInstance()");
		}
		// Proceed with creation
		System.out.println("Creating....");
	}

	public static SingletonPatternSolution getInstance() {
		// Double check locking fix
		if (soleInstance == null) { // Check 1
			synchronized (SingletonPatternSolution.class) {
				if (soleInstance == null) {// Check 2
					soleInstance = new SingletonPatternSolution();
				}
			}
		}
		return soleInstance;
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println(".. read resolve ..");
		return soleInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(
				"Cannot create clone, please use getInstance()");
	}
}

public class CorrectSingletonDef {
	public static void main(String[] args) throws Exception {

		SingletonPatternSolution s1 = SingletonPatternSolution.getInstance();
		SingletonPatternSolution s2 = SingletonPatternSolution.getInstance();

		print("s1", s1);
		print("s2", s2);

		// Reflection
		try {
			System.out.println("Using Reflection");
			Class clazz = Class
					.forName("practise.Patterns.singleton.SingletonPatternSolution");
			Constructor<SingletonPatternSolution> ctor = clazz
					.getDeclaredConstructor();
			ctor.setAccessible(true);
			SingletonPatternSolution s3 = ctor.newInstance();

			print("s3", s3);

		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

		// We succeeded on stopping reflection to access singleton
		// with Caused by: java.lang.RuntimeException: Cannot create, please use
		// getInstance()

		// Serialization/De-Serialization
		System.out.println("Using Serialization/De-Serialization");
		File fl = new File("F:/s2.ser");
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fl));
		oos.writeObject(s2);
		oos.close();
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fl));
		SingletonPatternSolution s4 = (SingletonPatternSolution) oin
				.readObject();
		fl.delete();

		print("s4", s4);

		// Clone
		try {
			System.out.println("Using Clone");
			SingletonPatternSolution s5 = (SingletonPatternSolution) s2.clone();
			print("s5", s5);
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex.getCause());
		}

		// Multi thread

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonTestMultiThread::useSingleton);
		service.submit(SingletonTestMultiThread::useSingleton);
		service.shutdown();

		// Multiple Class Loaders

		// If web container and EAR trying to load same class due to some issue
		// in that case if other is unavailable it'll create it's own

		// Garbage Collection

		// Garbage collection also may trigger violation to singleton
	}

	static void print(String name, SingletonPatternSolution object) {
		System.out.println(String.format("Object : %s, Hashcode: %d", name,
				object.hashCode()));
	}
}
