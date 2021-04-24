package test.codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mexstr {
	static List<String> al = new ArrayList<>();

	public static void main(String[] args) {
		findsubsequences("1100", "");
		al.removeIf(p -> p.length() == 0);
		List<Integer> decList = al.stream().map(s -> Integer.parseInt(s, 2))
				.distinct().sorted().collect(Collectors.toList());
		// al.stream().distinct().collect(Collectors.toList());
		// String small = al.stream().filter(p -> p.startsWith("0")).findFirst()
		// .get().replaceFirst("^0+(?!$)", "");
		System.out.println(Integer
				.toBinaryString(findSmallestMissingInt(decList)));
		System.out.println(decList);
	}

	private static int findSmallestMissingInt(List<Integer> list) {
		Integer i = 0;
		while (true) {
			Integer o = i;
			long x = list.stream().filter(p -> p.equals(o)).count();
			if (x == 0)
				break;
			else
				i++;
		}
		return i;
	}

	private static void findsubsequences(String s, String ans) {
		if (s.length() == 0) {
			al.add(ans);
			return;
		}

		findsubsequences(s.substring(1), ans + s.charAt(0));

		findsubsequences(s.substring(1), ans);
	}
}
