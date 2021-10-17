package test.prepBytes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AliceAndBooks {
	public static void main(String args[]) {

		// write your code here
		Scanner sc = new Scanner(System.in);
		Integer t, n;
		Long m;
		t = sc.nextInt();
		if (t >= 1 && t <= 100) {
			n = sc.nextInt();
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			m = sc.nextLong();
			List<Integer> subArr = Arrays.asList(arr).stream()
					.filter(e -> e < ((12) * (m / 60)))
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
			long x = (12) * (m / 60);
			int i = 0;
			while (x > 0) {
				x = x - subArr.get(i);
				i++;
			}
			System.out.println(i);
		}

		sc.close();
	}
}
