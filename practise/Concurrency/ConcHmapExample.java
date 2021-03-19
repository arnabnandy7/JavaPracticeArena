package practise.Concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ConcHmapExample {
	static Map<String, Long> orders = new ConcurrentHashMap<>();
	static Map<String, AtomicLong> ordersSolution = new ConcurrentHashMap<>();

	static void processOrders() {
		for (String city : orders.keySet()) {
			for (int i = 0; i < 50; i++) {
				Long oldOrder = orders.get(city);
				orders.put(city, oldOrder + 1);
			}
		}
	}

	static void processOrdersSolution() {
		for (String city : orders.keySet()) {
			for (int i = 0; i < 50; i++) {
				ordersSolution.get(city).getAndIncrement();
			}
		}
	}

	public static void executeThreads() throws InterruptedException {
		orders.put("Bombay", 0l);
		orders.put("Beijing", 0l);
		orders.put("London", 0l);
		orders.put("New York", 0l);

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConcHmapExample::processOrders);
		service.submit(ConcHmapExample::processOrders);

		service.awaitTermination(1, TimeUnit.SECONDS);
		service.shutdown();

		System.out.println(orders);
	}

	public static void executeThreadsSolution() throws InterruptedException {
		ordersSolution.put("Bombay", new AtomicLong());
		ordersSolution.put("Beijing", new AtomicLong());
		ordersSolution.put("London", new AtomicLong());
		ordersSolution.put("New York", new AtomicLong());

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConcHmapExample::processOrdersSolution);
		service.submit(ConcHmapExample::processOrdersSolution);

		service.awaitTermination(1, TimeUnit.SECONDS);
		service.shutdown();

		System.out.println(orders);
	}

	public static void main(String[] args) throws InterruptedException {
		// Problem of concurrent modification
		System.out.println("Normal concurrent modification using threads");
		for (int i = 0; i < 15; i++) {
			executeThreads();
		}
		// Solution to concurrent modification
		System.out
				.println("Concurrent modification using threads with Atomic variables");
		for (int i = 0; i < 15; i++) {
			executeThreadsSolution();
		}
	}
}
