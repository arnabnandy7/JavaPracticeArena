package test.oldCompetitivePrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class cubeFinder {
	public static void main(String[] args) {
		int num = 1000, count = 0;
		ArrayList<Integer> roots = generateCubeRoots(10000);
		for (int i = 1; i <= num; i++) {
			if (roots.contains(i)) {
				count++;
			}
		}

		System.out.println(count);

	}

	public static ArrayList<Integer> generateCubeRoots(int input) {
		ArrayList<Integer> roots = new ArrayList<Integer>();
		for (int i = 1; i <= input; i++) {
			for (int j = 2; j < 10; j++) {
				int cube = j * j * j;
				roots.add(cube * i);
			}
		}
		Set<Integer> set = new HashSet<>(roots);
		roots.clear();
		roots.addAll(set);
		Collections.sort(roots);

		return roots;
	}

	public static boolean checkCube(int input) {
		boolean result = false;

		for (int i = 1; i <= input; i++) {
			int cube = input * input * input;
			int sample = cube * i;
			System.out.println(input + "::" + cube + "::" + i + "::" + sample);
			if (input > 1 && (input == cube * i)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static int printCubes(int a, int b) {
		// Traverse through all numbers in given range
		// and one by one check if number is prime
		int count = 0;
		for (int i = a; i <= b; i++) {
			// Check if current number 'i'
			// is perfect cube
			for (int j = 1; j * j * j <= i; j++) {
				if (j * j * j == i) {
					count++;
					break;
				}
			}
		}
		return count;
	}

}
