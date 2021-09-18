package test.Oracle;

// program to check if the provided string was Palindrome or not using recursion.
public class CheckPalindromWithRecursion {
	public static void main(String[] args) {
		System.out.println(checkPalindrome("rotor", 0));
	}

	public static boolean checkPalindrome(String input, int x) {
		// System.err.println(x);
		x++;
		if (x <= input.length() / 2)
			checkPalindrome(input, x);
		return input.charAt(x) == input.charAt(input.length() - (x + 1));
	}
}
