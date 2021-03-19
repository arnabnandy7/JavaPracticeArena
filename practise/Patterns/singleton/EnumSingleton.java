package practise.Patterns.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

enum SingletonEnum{
	INSTANCE;
	
	public String getConfiguration(){
		return "sample";
	}
}

public class EnumSingleton {
	static void useSingleton() {
		SingletonEnum singleton = SingletonEnum.INSTANCE;
		print("singleton", singleton);
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(EnumSingleton::useSingleton);
		service.submit(EnumSingleton::useSingleton);
		service.shutdown();
	}

	static void print(String name, SingletonEnum object) {
		System.out.println(String.format("Object : %s, Hashcode: %d", name,
				object.hashCode()));
	}
}
