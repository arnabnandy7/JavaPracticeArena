package test.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChantuBantu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			for (int x = 0; x < t; x++) {
				int n = sc.nextInt();
				ArrayList<Long> gifts = new ArrayList<>();
				int g = sc.nextInt();
				for (int i = 0; i < g; i++) {
					gifts.add(sc.nextLong());
				}
				Collections.sort(gifts);
				System.out.println(gifts.stream().limit(n)
						.reduce(0L, Long::sum));
			}
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
