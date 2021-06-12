package test.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChocolateProblem {

	static int highestSum = 0;

	public static void getPermutations(int[] array) {
		helper(array, 0);
	}

	private static void helper(int[] array, int pos) {
		if (pos >= array.length - 1) {
			int prevItem = array[0];
			int total = 0;
			for (int i = 0; i < array.length - 1; i++) {
				// System.out.print(array[i] + ", ");
				total += (Math.abs(prevItem - array[i]));
				prevItem = array[i];
			}
			if (array.length > 0) {
				// System.out.print(array[array.length - 1]);
				total += (Math.abs(prevItem - array[array.length - 1]));
			}
			// System.out.print(" -> " + total);
			if (total > highestSum)
				highestSum = total;
			return;
		}

		for (int i = pos; i < array.length; i++) {

			int t = array[pos];
			array[pos] = array[i];
			array[i] = t;

			helper(array, pos + 1);

			t = array[pos];
			array[pos] = array[i];
			array[i] = t;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int j = 0; j < n; j++) {
			highestSum = 0;
			int x = sc.nextInt();
			if (x > 1) {
				List<Integer> comb = new ArrayList<Integer>();
				for (int i = 1; i <= x; i++) {
					comb.add(i);
				}
				int[] numbers = toIntArray(comb);
				getPermutations(numbers);
				System.out.println(highestSum);
				comb.clear();
			} else {
				System.out.println(1);
			}
		}
		sc.close();
	}

	public static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		int i = 0;
		for (Integer e : list)
			ret[i++] = e;
		return ret;
	}

}
