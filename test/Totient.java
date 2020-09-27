package test;

import java.util.ArrayList;

public class Totient {
	public static void main(String[] args) {
		ArrayList<Integer> series = new ArrayList<Integer>();
		for (int i = 1; i <= 7; i++) {
			if (i == 1) {
				series.add(1);
			} else {
				series.add(totient(i));
			}
		}
		System.out.println(series.toString().replace(",", "").replace("[", "")
				.replace("]", ""));
	}

	public static int totient(int num) {
		int count = 0;
		for (int a = 1; a < num; a++) {
			if (GCD(num, a) == 1) {
				count++;
			}
		}
		return (count);
	}

	public static int GCD(int a, int b) {
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		if (a % b == 0) {
			return (b);
		}
		return (GCD(a % b, b));
	}

}
