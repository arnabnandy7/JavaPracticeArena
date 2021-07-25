package test.techgig;

import java.util.Scanner;

public class ChocolateProblem {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long[] p = new long[sc.nextInt()];
		for (int q = 0; q < p.length; q++) {
			p[q] = sc.nextLong();
		}
		for (int j = 0; j < p.length; j++) {
			long q = p[j];
			if (q == 1)
				q = 2;
			long a = (q / 2);
			for (long i = 2; i < q; i++) {
				a += i;
			}
			System.out.println(a);
		}
		sc.close();
	}
}
