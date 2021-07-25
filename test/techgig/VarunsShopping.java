package test.techgig;

import java.util.ArrayList;

public class VarunsShopping {

	public static void printSubsequences(int[] arr, int index,
			ArrayList<Integer> path) {

		// Print the subsequence when reach
		// the leaf of recursion tree
		if (index == arr.length) {

			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0)
				System.out.println(path);
		}

		else {

			// Subsequence without including
			// the element at current index
			printSubsequences(arr, index + 1, path);

			path.add(arr[index]);

			// Subsequence including the element
			// at current index
			printSubsequences(arr, index + 1, path);

			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
		}
		return;
	}

	// Driver code
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 8, 10, 11 };

		// Auxillary space to store each path
		ArrayList<Integer> path = new ArrayList<>();
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0
					&& (((arr[i] / 2) % 2 == 0) || (arr[i] / 2) == 1))
				x++;
		}
		 printSubsequences(arr, 0, path);
		System.out.println(x);
	}
}
