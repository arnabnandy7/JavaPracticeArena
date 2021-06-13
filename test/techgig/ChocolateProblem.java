package test.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ChocolateProblem {

	static AtomicInteger highestSum = new AtomicInteger(0);

	public static void getPermutations(AtomicInteger[] array) {
		// ChocolateProblem perm = new ChocolateProblem();
		// Thread thread = new Thread(() -> {
		// perm.helper(array, 0);
		// });
		// thread.start();
	}

	private synchronized void helper(AtomicInteger[] array, int pos) {
		if (pos >= array.length - 1) {
			AtomicInteger prevItem = array[0];
			AtomicInteger total = new AtomicInteger(0);
			for (int i = 0; i < array.length - 1; i++) {
				System.out.print(array[i] + ", ");
				total = new AtomicInteger(total.intValue()
						+ (Math.abs(prevItem.intValue() - array[i].intValue())));
				prevItem = array[i];
			}
			if (array.length > 0) {
				System.out.print(array[array.length - 1]);
				total = new AtomicInteger(total.intValue()
						+ (Math.abs(prevItem.intValue()
								- array[array.length - 1].intValue())));
			}
			System.out.print(" -> " + total);
			System.out.println();
			if (total.intValue() > highestSum.intValue())
				highestSum = total;
			return;
		}

		for (int i = pos; i < array.length; i++) {

			int t = array[pos].intValue();
			array[pos] = array[i];
			array[i] = new AtomicInteger(t);

			helper(array, pos + 1);

			t = array[pos].intValue();
			array[pos] = array[i];
			array[i] = new AtomicInteger(t);
		}
	}

	public static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		int i = 0;
		for (Integer e : list)
			ret[i++] = e;
		return ret;
	}

	public static void main(String args[]) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			if (n >= 1 && n <= 100) {
				for (int j = 0; j < n; j++) {
					highestSum = new AtomicInteger(0);
					int x = sc.nextInt();
					if (x >= 1 && x <= 10000000) {
						if (x > 1) {
							List<Integer> comb = new ArrayList<Integer>();
							for (int i = 1; i <= x; i++) {
								comb.add(i);
							}
							int[] numbers = toIntArray(comb);
							AtomicInteger[] atomNumbers = new AtomicInteger[comb
									.size()];
							for (int i = 0; i < comb.size(); i++) {
								atomNumbers[i] = new AtomicInteger(numbers[i]);
							}
							// getPermutations(atomNumbers);
							// System.out.println(highestSum);
							// comb.clear();

							ChocolateProblem perm = new ChocolateProblem(
									numbers);
							perm.GetFirst();
							while (perm.HasNext()) {
								Thread thread = new Thread(() -> {
									perm.GetNext();
								});
								thread.start();
							}

						} else {
							System.out.println(1);
						}
					} else {
						System.out.println(0);
					}
				}
			}

			sc.close();
		} catch (Exception e) {

		}
		// Write code here
	}

	// The input array for permutation
	private final int Arr[];

	// Index array to store indexes of input array
	private int Indexes[];

	// The index of the first "increase"
	// in the Index array which is the smallest
	// i such that Indexes[i] < Indexes[i + 1]
	private int Increase;

	// Constructor
	public ChocolateProblem(int arr[]) {
		this.Arr = arr;
		this.Increase = -1;
		this.Indexes = new int[this.Arr.length];
	}

	// Initialize and output
	// the first permutation
	public void GetFirst() {

		// Allocate memory for Indexes array
		this.Indexes = new int[this.Arr.length];

		// Initialize the values in Index array
		// from 0 to n - 1
		for (int i = 0; i < Indexes.length; ++i) {
			this.Indexes[i] = i;
		}

		// Set the Increase to 0
		// since Indexes[0] = 0 < Indexes[1] = 1
		this.Increase = 0;

		// Output the first permutation
		this.Output();
	}

	// Function that returns true if it is
	// possible to generate the next permutation
	public boolean HasNext() {

		// When Increase is in the end of the array,
		// it is not possible to have next one
		return this.Increase != (this.Indexes.length - 1);
	}

	// Output the next permutation
	public synchronized void GetNext() {

		// Increase is at the very beginning
		if (this.Increase == 0) {

			// Swap Index[0] and Index[1]
			this.Swap(this.Increase, this.Increase + 1);

			// Update Increase
			this.Increase += 1;
			while (this.Increase < this.Indexes.length - 1
					&& this.Indexes[this.Increase] > this.Indexes[this.Increase + 1]) {
				++this.Increase;
			}
		} else {

			// Value at Indexes[Increase + 1] is greater than Indexes[0]
			// no need for binary search,
			// just swap Indexes[Increase + 1] and Indexes[0]
			try {
				if (this.Indexes[this.Increase + 1] > this.Indexes[0]) {
					this.Swap(this.Increase + 1, 0);
				} else {

					// Binary search to find the greatest value
					// which is less than Indexes[Increase + 1]
					int start = 0;
					int end = this.Increase;
					int mid = (start + end) / 2;
					int tVal = this.Indexes[this.Increase + 1];
					while (!(this.Indexes[mid] < tVal && this.Indexes[mid - 1] > tVal)) {
						if (this.Indexes[mid] < tVal) {
							end = mid - 1;
						} else {
							start = mid + 1;
						}
						mid = (start + end) / 2;
					}

					// Swap
					this.Swap(this.Increase + 1, mid);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			// Invert 0 to Increase
			for (int i = 0; i <= this.Increase / 2; ++i) {
				this.Swap(i, this.Increase - i);
			}

			// Reset Increase
			this.Increase = 0;
		}
		this.Output();
	}

	// Function to output the input array
	private void Output() {
		for (int i = 0; i < this.Indexes.length; ++i) {

			// Indexes of the input array
			// are at the Indexes array
			System.out.print(this.Arr[this.Indexes[i]]);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Swap two values in the Indexes array
	private void Swap(int p, int q) {
		int tmp = this.Indexes[p];
		this.Indexes[p] = this.Indexes[q];
		this.Indexes[q] = tmp;
	}
}
