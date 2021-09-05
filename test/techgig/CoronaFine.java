package test.techgig;

import java.util.Scanner;

public class CoronaFine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer noOfPeople = sc.nextInt();
		if (noOfPeople <= 100) {
			System.out.println("0 No Fine");
		} else if (noOfPeople > 100 && noOfPeople <= 200) {
			System.out.println(((noOfPeople - 100) * 500) + " Warning");
		} else if (noOfPeople > 200) {
			System.out.println(((noOfPeople - 100) * 1000) + " Register Case");
		}
		sc.close();
	}
}
