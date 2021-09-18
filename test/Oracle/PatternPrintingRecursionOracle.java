package test.Oracle;

// 
public class PatternPrintingRecursionOracle {
	static int x = 1;

	public static void main(String[] args) {
		traverseLines(7, true);
		traverseLines(7, false);
	}

	public static void generateAsterisk(int count) {
		if (count >= 1) {
			System.out.print("*");
			generateAsterisk(count - 1);
		}
	}

	public static void traverseLines(int count, boolean rev) {
		if (count >= 1 && rev) {
			System.out.println();
			generateAsterisk(count);
			traverseLines(count - 1, rev);
		}
		if (x <= count && !rev) {
			x++;
			System.out.println();
			generateAsterisk(x);
			if (x < count) {
				traverseLines(count, rev);
			}
		}
	}
}
