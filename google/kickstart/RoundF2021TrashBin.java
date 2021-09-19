package google.kickstart;

import java.util.Scanner;

public class RoundF2021TrashBin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int j = 0; j < t; j++) {
			int len = sc.nextInt();
			String s = sc.next();
			int i = 0;
			int totalDist = 0;
			// System.out.println(s.lastIndexOf('1'));
			while (i < s.length()) {

				if (s.charAt(i) != '1' && s.length() - 1 != i
						&& i <= s.lastIndexOf('1') + 1) {
//					System.out.println("min" + prevDist(s, i) + " "
//							+ nextDist(s, i));
					totalDist += Math.min(prevDist(s, i), nextDist(s, i));
				}
				if (s.lastIndexOf('1') + 1 < i) {
//					System.out.println("max" + prevDist(s, i) + " "
//							+ nextDist(s, i));
					totalDist += Math.max(prevDist(s, i), nextDist(s, i));
				}
				i++;
			}
			System.out.println("Case #" + (j + 1) + ": " + totalDist);
		}
		sc.close();
	}

	static int prevDist(String s, int idx) {
		int i = idx, x = 0;
		while (i >= 0) {
			char chr = s.charAt(i--);
			if (chr == '0')
				x++;
			if (chr == '1')
				break;
		}
		return x;
	}

	static int nextDist(String s, int idx) {
		int i = idx, x = 0;
		while (i <= s.length() - 1) {
			char chr = s.charAt(i++);
			if (chr == '0')
				x++;
			if (chr == '1')
				break;
		}
		return x;
	}

}
