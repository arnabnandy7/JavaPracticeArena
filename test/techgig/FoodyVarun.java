package test.techgig;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FoodyVarun {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextDouble();
		}
		System.out.println(IntStream.range(0, n)
				.map(i -> (int) (sc.nextDouble() / arr[i])).min().getAsInt());
		sc.close();
	}
}
