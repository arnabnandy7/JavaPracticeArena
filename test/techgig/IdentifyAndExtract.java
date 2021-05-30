package test.techgig;

import java.util.Scanner;
import java.util.StringTokenizer;

public class IdentifyAndExtract {

	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		if (st.length() >= 1 && st.length() <= 100000) {
			if (st.charAt(st.length() - 1) == '.')
				st = st.substring(0, st.length() - 1);
			StringTokenizer x = new StringTokenizer(st, " ");
			int c = 0;
			while (x.hasMoreTokens()) {
				String temp = x.nextToken();
				if (temp.length() != temp.replaceAll("[^0-9]", "").length()
						&& temp.replaceAll("[^0-9]", "").length() > 0) {
					if (!isCountsOrUnitOfMeasurement(temp).isEmpty()) {
						c = 1;
						System.out.println(temp + ",[" + st.indexOf(temp) + ","
								+ (st.indexOf(temp) + temp.length()) + "],"
								+ isCountsOrUnitOfMeasurement(temp));
					}
				}
				if (isNumeric(temp)) {
					String type = x.nextToken();
					if (isDerivedUnit(type)) {
						String d = x.nextToken();
						type = type + " " + d;
					}
					// System.out.println(type);
					if (!isCountsOrUnitOfMeasurement(type).isEmpty()) {
						c = 1;
						System.out.println(temp + " " + type + ",["
								+ st.indexOf(temp) + ","
								+ (st.indexOf(type) + type.length()) + "],"
								+ isCountsOrUnitOfMeasurement(type));
					}
				}
			}
			if (c == 0) {
				System.out.println("NONE");
			}
		} else {
			System.out.println("NONE");
		}

		sc.close();

	}

	public static boolean isNumeric(String str) { 
        return str.chars().allMatch(Character::isDigit);
    }

	public static boolean isDerivedUnit(String s) {
		if (s.toLowerCase().contains("cubic")
				|| s.toLowerCase().contains("square")
				|| s.toLowerCase().contains("fl"))
			return true;
		return false;
	}

	public static String isCountsOrUnitOfMeasurement(String type) {
		if (type.toLowerCase().contains("pixels")
				|| type.toLowerCase().contains("oz")
				|| type.toLowerCase().contains("mol")
				|| type.toLowerCase().contains("km")
				|| type.toLowerCase().contains("foot")
				|| type.toLowerCase().equals("gr")
				|| type.toLowerCase().equals("cd")
				|| type.toLowerCase().contains("dr")
				|| type.toLowerCase().contains("lb")
				|| type.toLowerCase().contains("st")
				|| type.toLowerCase().contains("qr")
				|| type.toLowerCase().contains("qtr")
				|| type.toLowerCase().contains("cwt")
				|| type.toLowerCase().equals("t")
				|| type.toLowerCase().contains("slug")
				|| type.toLowerCase().contains("pt")
				|| type.toLowerCase().contains("qt")
				|| type.toLowerCase().contains("gal")
				|| type.toLowerCase().contains("gi")
				|| type.toLowerCase().contains("kg")
				|| type.toLowerCase().equals("s")
				|| type.toLowerCase().equals("m")
				|| type.toLowerCase().equals("a")
				|| type.toLowerCase().equals("k")
				|| type.toLowerCase().contains("rad"))
			return "Unit of Measure";
		if (type.toLowerCase().endsWith("s"))
			return "Counts";
		// System.out.println(type);
		return "";
	}
}
