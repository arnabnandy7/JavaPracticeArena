package practise.Java9.FunctionalInterfaces;

import java.time.LocalTime;
import java.util.Objects;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		System.out.println(composeHashcodes3("Hello", "world"));
		System.out.println(composeHashcodes3("Hello", null));
	}

	public static int composeHashcodes(Object a, Object b) {
		return a.hashCode() ^ b.hashCode();
	}

	// A "slow" method
	public static String getApplicationStatus() {
		System.out.println("getApplicationStatus");
		return "It's " + LocalTime.now();
	}

	public static int composeHashcodes2(Object a, Object b) {
		Objects.requireNonNull(a, "a may not be null! "
				+ getApplicationStatus());
		Objects.requireNonNull(b, "b may not be null! "
				+ getApplicationStatus());

		return a.hashCode() ^ b.hashCode();
	}

	public static int composeHashcodes3(Object a, Object b) {
		Objects.requireNonNull(a, () -> "a may not be null! "
				+ getApplicationStatus());
		Objects.requireNonNull(b, () -> "b may not be null! "
				+ getApplicationStatus());

		return a.hashCode() ^ b.hashCode();
	}
}
