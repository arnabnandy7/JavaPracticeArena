package test.Oracle;

import java.util.HashMap;
import java.util.Map;

public class DateParsingWithoutClassDate {

	private static final Map<Integer, Integer> date;

	static {
		date = new HashMap<Integer, Integer>();
		date.put(1, 31);
		date.put(2, 28);
		date.put(3, 31);
		date.put(4, 30);
		date.put(5, 31);
		date.put(6, 30);
		date.put(7, 31);
		date.put(8, 31);
		date.put(9, 30);
		date.put(10, 31);
		date.put(11, 30);
		date.put(12, 31);
	}

	public void updateDate(int m, int d, int y, int days) {
		int temp = date.get(m);
		// for finding leap year
		if (m == 2 && (y % 4 == 0 && y % 100 != 0 && y % 400 != 0)) {
			temp = date.get(m) + 1;
		}
		if (d + days > temp) {
			if (m <= 11) {
				updateDate(m + 1, d, y, days - temp);
			} else {
				updateDate(1, d, y + 1, days - temp);
			}
		} else {
			System.out.println("Upadate Date: " + m + "/" + (d + days) + "/"
					+ y);
		}
	}

	public static void main(String[] args) {
		DateParsingWithoutClassDate id = new DateParsingWithoutClassDate();
		id.updateDate(2, 27, 2020, 34);
	}
}
