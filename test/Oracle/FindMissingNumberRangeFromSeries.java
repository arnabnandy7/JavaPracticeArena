package test.Oracle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// to print the series of missing numbers in array from 0-99.
// it should be like, 0-2 , 4-9, 11-76 , 78-99 for array like [3,10,77]
public class FindMissingNumberRangeFromSeries {
	static int lowerLimit = 0;
	static int upperLimit = 0;

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(3, 10, 77);
		Collections.sort(arr);
		generateMissingRanges(arr);
	}

	public static void generateMissingRanges(List<Integer> arr) {
		int i = 0;
		while (upperLimit < 99 && i < arr.size()) {
			upperLimit = arr.get(i);
			System.out.println(lowerLimit + "-" + (upperLimit - 1));
			lowerLimit = upperLimit + 1;
			i++;
		}
		System.out.println(lowerLimit + "-99");

	}
}
