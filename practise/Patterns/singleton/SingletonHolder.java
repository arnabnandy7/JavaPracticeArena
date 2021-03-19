package practise.Patterns.Singleton;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingletonPatternSolution2 implements Serializable, Cloneable {

	private SingletonPatternSolution2() {
		System.out.println("Creating....");
	}

	public static SingletonPatternSolution2 getInstance() {
		return Holder.INSTANCE;
	}
	// Singleton holder
	static class Holder {
		static final SingletonPatternSolution2 INSTANCE = new SingletonPatternSolution2();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class SingletonHolder {
	static void useSingleton() {
		SingletonPatternSolution2 singleton = SingletonPatternSolution2
				.getInstance();
		print("singleton", singleton);
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonHolder::useSingleton);
		service.submit(SingletonHolder::useSingleton);
		service.shutdown();
	}

	static void print(String name, SingletonPatternSolution2 object) {
		System.out.println(String.format("Object : %s, Hashcode: %d", name,
				object.hashCode()));
	}
}
