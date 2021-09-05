package test.techgig;

import java.util.Scanner;

public class SportsTournament {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases, k = 0;
		int[] input = new int[100], result = new int[100];
		cases = sc.nextInt();
		for (int x = 0; x < cases; x++) {
			result[x] = 0;
		}
		for (int i = 0; i < cases; i++) {
			input[i] = sc.nextInt();
		}
		for (int j = 0; j < cases; j++) {
			while (input[j] > 1) {
				if (input[j] % 2 == 0) {
					result[k] = result[k] + input[j] / 2;
					input[j] = input[j] / 2;
				} else {
					result[k] = result[k] + input[j] / 2;
					result[k] = result[k] + 1;
					input[j] = input[j] / 2;
				}
			}
			k++;
		}
		for (int l = 0; l < cases; l++) {
			System.out.println(result[l]);
		}
		sc.close();
	}
}
