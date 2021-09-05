package test.techgig;

import java.util.Scanner;

public class ReverseComplement {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(generateFinalComplement(reverseString(s)));
		sc.close();
	}

	private static String generateFinalComplement(String list) {
		StringBuilder newList = new StringBuilder();
		for (int i = 0; i < list.length(); i++) {

			if (list.charAt(i) == 'T') {
				newList.append('A');
			} else if (list.charAt(i) == 'G') {
				newList.append('C');
			} else if (list.charAt(i) == 'C') {
				newList.append('G');
			} else if (list.charAt(i) == 'A') {
				newList.append('T');
			}
		}
		return newList.toString();
	}

	public static String reverseString(String source) {
		int i, len = source.length();
		StringBuilder dest = new StringBuilder(len);
		for (i = (len - 1); i >= 0; i--) {
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}
}
