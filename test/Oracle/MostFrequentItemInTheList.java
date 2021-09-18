package test.Oracle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a list of integers, return the most frequent item in the list.
public class MostFrequentItemInTheList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 1, 1, 4, 5, 6, 1, 8, 9, 5, 5,
				5, 4);
		findFrequentElement(list);
	}

	public static void findFrequentElement(List<Integer> list) {
		Map<Integer, Long> map = new HashMap<Integer, Long>();
		list.stream().forEach(
				a -> {
					long temp = list.stream()
							.filter(x -> x.intValue() == a.intValue()).count();
					map.put(a.intValue(), temp);
				});
		Long maxCount = 0L;
		for (Integer item : map.keySet()) {
			if (maxCount < map.get(item)) {
				maxCount = map.get(item);
			}
		}
		for (Integer item : map.keySet()) {
			if (map.get(item).equals(maxCount)) {
				System.out.println(item);
			}
		}
	}
}
