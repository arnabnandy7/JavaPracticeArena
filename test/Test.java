package test;

public class Test {
	static boolean x;
	static boolean y;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(y && !x);
		System.out.println(x || y);
			x = x || y && !x;
			y = y && x || y;
			System.out.println(x);
			System.out.println(y);
			   
	}
}
