package test.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketBatManufacturer {

	public int weight;
	public int price;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		List<CricketBatManufacturer> cricList = new ArrayList<CricketBatManufacturer>();
		List<CricketBatManufacturer> batList = new ArrayList<CricketBatManufacturer>();
		int C = sc.nextInt();
		int N = sc.nextInt();
		for (int i = 0; i < C; i++) {
			CricketBatManufacturer cbm = new CricketBatManufacturer();
			cbm.setWeight(sc.nextInt());
			cbm.setPrice(sc.nextInt());
			cricList.add(cbm);
		}
		for (int i = 0; i < N; i++) {
			CricketBatManufacturer cbm = new CricketBatManufacturer();
			cbm.setWeight(sc.nextInt());
			cbm.setPrice(sc.nextInt());
			batList.add(cbm);
		}

		int sumOfTotalBatSell = 0;
		for (CricketBatManufacturer cricketer : cricList) {
			sumOfTotalBatSell += checkPrice(cricketer.getWeight(),
					cricketer.getPrice(), batList);
		}
		System.out.println(sumOfTotalBatSell);
		sc.close();
	}

	public static int checkPrice(int weight, int price,
			List<CricketBatManufacturer> batList) {
		int s = 0;
		for (CricketBatManufacturer bat : batList) {
			if (bat.getWeight() > weight && bat.getPrice() <= price) {
				s = 1;
				break;
			}
		}
		return s;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
