package test.techgig;

import java.util.Scanner;

public class WinOrLose {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int n = 0, m = 0;
		for (int k = 0; k < testCases; k++) {

			int size = sc.nextInt();

			int[] playersEnergy = new int[size];
			int[] villainStrength = new int[size];

			for (int i = 0; i < villainStrength.length; i++) {
				villainStrength[i] = sc.nextInt();
			}

			for (int i = 0; i < playersEnergy.length; i++) {
				playersEnergy[i] = sc.nextInt();
			}
			for (int i = 0; i < playersEnergy.length; i++) {
				if (playersEnergy[i] > villainStrength[i])
					n++;
				else
					m++;

			}
			if (n > m)
				System.out.println("WIN");
			else
				System.out.println("LOSE");
		}
		sc.close();
	}
}
