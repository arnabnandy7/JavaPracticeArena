package practise.Concurrency;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHMap {

	public static void main(String[] args) {
		Map<Order, Integer> orders = new WeakHashMap<>();

		// These two not having any references hence more likely to gets removed
		// once garbage collection got called

		orders.put(new Order(1, "khsfkjh"), 100);
		orders.put(new Order(1, "lkasfh"), 200);

		Order ord = new Order(2, "lsjfka");

		orders.put(ord, 400); // This is having strong reference hence after
								// garbage collection called it should be remain
								// in hashmap

		// Printing size of map before garbage collection
		System.out.println(orders.size());

		// Calling garbage collection explicitly, it may or may not work
		System.gc();
		// Runtime.getRuntime().gc();

		// Printing size of map after garbage collection
		System.out.println(orders.size());

	}

}

class Order {
	int orderId;
	String details;

	public Order(int anId, String theDetails) {
		orderId = anId;
		details = theDetails;
	}
}
