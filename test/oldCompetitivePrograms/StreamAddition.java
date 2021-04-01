package test.oldCompetitivePrograms;

import java.util.ArrayList;
import java.util.List;

public class StreamAddition {
	private int id;
	private double price;
	private int stock;

	public StreamAddition(int id, double price, int stock) {
		this.id = id;
		this.price = price;
		this.stock = stock;
	}

	public StreamAddition() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StreamAddition item1 = new StreamAddition(1, 10, 5);
		StreamAddition item2 = new StreamAddition(2, 15, 6);
		StreamAddition item3 = new StreamAddition(3, 25, 7);
		StreamAddition item4 = new StreamAddition(4, 40, 2);

		// List<StreamAddition> items = Arrays.asList(item1, item2, item3,
		// item4);
		List<StreamAddition> items = new ArrayList<StreamAddition>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		// Sum item value from the list as per condition
		double totalPrice = items.stream().filter(e -> e.getId() > 2)
				.mapToDouble(d -> d.getPrice()).sum();
		int totalStock = items.stream().filter(e -> e.getId() > 2)
				.filter(e -> e.getStock() > 2).mapToInt(i -> i.getStock())
				.sum();
		long totalStockCnt = items.stream().filter(e -> e.getId() > 2).count();
		System.out.println(totalStockCnt);
		// Finding max item value from the list as per condition
		int maxId = items.stream().mapToInt(i -> i.getId()).max().getAsInt();
		/*
		 * items = items.stream().filter(e -> e.getId() < 1)
		 * .collect(Collectors.toList());
		 */
		// Remove element depending upon condition (predicates)
		// items.removeIf(e -> e.getId()>0 && e.getStock()<6);

		StreamAddition itemGen = new StreamAddition();
		itemGen.setId(maxId + 1);
		itemGen.setPrice(totalPrice);
		itemGen.setStock(totalStock);
		items.add(itemGen);

		System.out.println("totalPrice :: " + totalPrice);
		System.out.println("totalStock :: " + totalStock);
		System.out.println("maxId :: " + maxId);
		// Modifying last element price
		items.get(items.size() - 1).setPrice(50);
		System.out.println(items);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StreamAddition [id=" + id + ", price=" + price + ", stock="
				+ stock + "]";
	}

}
