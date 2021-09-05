package test.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 Sample 1 
 Input
 10
 3 3
 5 7 9
 6 2 7
 Output
 9

 Input
 10
 3 3
 8 9 10
 4 6 3
 Output
 -1

 Input
 20
 3 3
 10 5 8
 11 7 4
 Output
 19

 */
public class VarunsShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int budget = sc.nextInt();
		int J = sc.nextInt();
		int T = sc.nextInt();
		if (budget >= 1 && budget <= 1000000 && J >= 1 && J <= 1000 && T >= 1
				&& T <= 1000) {
			Integer[] A = new Integer[J];
			Integer[] B = new Integer[T];
			for (int i = 0; i < J; i++) {
				int temp = sc.nextInt();
				if (temp >= 1 && temp <= 1000000) {
					A[i] = temp;
				}
			}
			for (int i = 0; i < T; i++) {
				int temp = sc.nextInt();
				if (temp >= 1 && temp <= 1000000) {
					B[i] = temp;
				}
			}

			MaxPairSum(A, B, budget);
		}

		sc.close();
	}

	public static void MaxPairSum(Integer[] A, Integer[] B, int budget) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				if (sum < budget) {
					results.add(sum);
				}
			}
		}
		System.out.println(results.size() > 0 ? Collections.max(results) : -1);
	}
}
