package test.Oracle;

/* Program to find all the patterns of 0(1+)0 in the given string */

import java.util.*;

public class FindPattern {
	static int find_pattern(char str[]) {
		char last = str[0];
		int i = 1, counter = 0;
		while (i < str.length) {
			/* We found 1 and last character was '0', state change */
			if (str[i] == '1' && last == '0') {
				while (str[i] == '1')
					i++;
				/* After the stream of 1's, we got a '0', counter incremented */
				if (str[i] == '0')
					counter++;
			}
			/* Store the last character */
			last = str[i];
			i++;
		}
		return counter;
	}

	public static void main(String args[]) {
		String string;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string : ");
		string = sc.next();
		char[] str = string.toCharArray();
		System.out.print("Number of patterns : " + find_pattern(str));
		sc.close();
	}
}