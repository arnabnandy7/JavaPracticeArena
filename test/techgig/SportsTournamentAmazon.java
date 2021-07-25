package test.techgig;

import java.util.Scanner;

public class SportsTournamentAmazon {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		final int numberOfTests = sc.nextInt();
		final int numberOfTeams[] = new int[numberOfTests];
		for (int i = 0; i < numberOfTeams.length; i++) {
			numberOfTeams[i] = sc.nextInt();
		}
		for (int i = 0; i < numberOfTeams.length; i++) {
			System.out.println(numberOfTeams[i] - 1);
		}
		sc.close();
	}
}
