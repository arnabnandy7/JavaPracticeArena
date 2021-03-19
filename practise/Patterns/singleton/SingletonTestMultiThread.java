package practise.Patterns.Singleton;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestClassSingletonPatternThread implements Serializable, Cloneable {
	// private static TestClassSingletonPattern soleInstance = new
	// TestClassSingletonPattern(); // eager loading
	private static TestClassSingletonPatternThread soleInstance = null; // lazy

	// loading

	private TestClassSingletonPatternThread() {
		System.out.println("Creating....");
	}

	// using synchronized in getInstance may solve the issue 
	public static TestClassSingletonPatternThread getInstance() {
		// lazy part started
		if (soleInstance == null) {
			soleInstance = new TestClassSingletonPatternThread();
		}
		// lazy part ended
		return soleInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class SingletonTestMultiThread {
	static void useSingleton() {
		TestClassSingletonPatternThread singleton = TestClassSingletonPatternThread
				.getInstance();
		print("singleton", singleton);
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonTestMultiThread::useSingleton);
		service.submit(SingletonTestMultiThread::useSingleton);
		service.shutdown();
	}

	static void print(String name, TestClassSingletonPatternThread object) {
		System.out.println(String.format("Object : %s, Hashcode: %d", name,
				object.hashCode()));
	}
}
