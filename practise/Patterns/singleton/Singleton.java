package practise.Patterns.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

class TestClassSingletonPattern implements Serializable, Cloneable {
	private static TestClassSingletonPattern soleInstance = new TestClassSingletonPattern();

	private TestClassSingletonPattern() {
		System.out.println("Creating....");
	}

	public static TestClassSingletonPattern getInstance() {
		return soleInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class Singleton {
	public static void main(String[] args) throws Exception {
		TestClassSingletonPattern s1 = TestClassSingletonPattern.getInstance();
		TestClassSingletonPattern s2 = TestClassSingletonPattern.getInstance();

		print("s1", s1);
		print("s2", s2);

		// Reflection
		Class clazz = Class
				.forName("practise.Patterns.singleton.TestClassSingletonPattern");
		Constructor<TestClassSingletonPattern> ctor = clazz
				.getDeclaredConstructor();
		ctor.setAccessible(true);
		TestClassSingletonPattern s3 = ctor.newInstance();

		print("s3", s3);

		// Serialization/De-Serialization
		File fl = new File("F:/s2.ser");
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fl));
		oos.writeObject(s2);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fl));
		TestClassSingletonPattern s4 = (TestClassSingletonPattern) ois
				.readObject();
		fl.delete();

		print("s4", s4);

		// Clone
		TestClassSingletonPattern s5 = (TestClassSingletonPattern) s2.clone();
		print("s5", s5);

		// Multiple Class Loaders

		// If web container and EAR trying to load same class due to some issue
		// in that case if other is unavailable it'll create it's own
		
		// Garbage Collection
		
		// Garbage collection also may trigger violation to singleton
	}
	
	static void useSingleton() {
		TestClassSingletonPattern singleton = TestClassSingletonPattern
				.getInstance();
		print("singleton", singleton);
	}

	static void print(String name, TestClassSingletonPattern object) {
		System.out.println(String.format("Object : %s, Hashcode: %d", name,
				object.hashCode()));
	}
}