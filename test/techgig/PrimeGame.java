package test.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		if (T >= 1 && T <= 10) {
			for (int i = 0; i < T; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				if (L >= 2 && L <= R && R <= 1000000) {
					List<Integer> result = segmentedSieve(L, R);
					if (result.isEmpty()) {
						System.out.println("-1");
					} else if (result.size() == 1) {
						System.out.println("0");
					} else {
						System.out.println(Collections.max(result)
								- Collections.min(result));
					}
				}
			}
		}
		sc.close();
	}

	static void simpleSieve(int limit, List<Integer> prime) {
		int bound = (int) Math.sqrt(limit);

		boolean[] mark = new boolean[bound + 1];
		for (int i = 0; i <= bound; i++)
			mark[i] = true;

		for (int i = 2; i * i <= bound; i++) {
			if (mark[i] == true) {
				for (int j = i * i; j <= bound; j += i)
					mark[j] = false;
			}
		}

		for (int i = 2; i <= bound; i++) {
			if (mark[i] == true)
				prime.add(i);
		}
	}

	static List<Integer> segmentedSieve(int low, int high) {
		List<Integer> prime = new ArrayList<>();
		List<Integer> prmRttn = new ArrayList<>();
		simpleSieve(high, prime); // stores primes upto

		boolean[] mark = new boolean[high - low + 1];
		for (int i = 0; i < mark.length; i++)
			mark[i] = true;

		for (int i = 0; i < prime.size(); i++) {
			int loLim = (low / prime.get(i)) * prime.get(i);
			if (loLim < low)
				loLim += prime.get(i);
			if (loLim == prime.get(i))
				loLim += prime.get(i);

			for (int j = loLim; j <= high; j += prime.get(i)) {
				mark[j - low] = false;
			}
		}

		for (int i = low; i <= high; i++) {
			if (mark[i - low] == true)
				prmRttn.add(i);
		}
		return prmRttn;
	}
}
