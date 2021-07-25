package test.techgig;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DominantInitials {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Map<Character, Long> charFrequency = sc
					.next()
					.chars()
					.mapToObj(c -> (char) c)
					.collect(
							Collectors.groupingBy(Function.identity(),
									Collectors.counting()));
			List<Character> result = charFrequency
					.entrySet()
					.stream()
					.filter(entry -> entry.getValue().equals(
							Collections.max(charFrequency.values())))
					.map(Map.Entry::getKey).sorted()
					.collect(Collectors.toList());
			System.out.println(result.get(0));
		}
		sc.close();
	}
}
