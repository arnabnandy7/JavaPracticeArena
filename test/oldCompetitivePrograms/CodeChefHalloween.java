package test.oldCompetitivePrograms;

import java.util.*;

public class CodeChefHalloween {
	
	private static int ARRAY_SIZE = 0;
	private static int SIZE_OF_SUBARRAYS = 0;
	private static Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
		    // Creates an array
	        ARRAY_SIZE = scanner.nextInt();

	        SIZE_OF_SUBARRAYS = scanner.nextInt();

		    Integer arr[] = new Integer[ARRAY_SIZE];

		    for (int i = 0; i < ARRAY_SIZE; i++) {
		        arr[i] = scanner.nextInt();
		    }
		    
		    scanner.close();
		    // Converts the array to arrayList
		    ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

		    // Sorts the list
		    Collections.sort(list);

		    recursion(list); // This method work until find all of the sorted lists 
		    // with size SIZE_OF_SUBARRAYS in array with size ARRAY_SIZE 
		    ArrayList<Integer> results = new ArrayList<Integer>();
		    // Writes content of the set to the console
		    for (List<Integer> list2 : set) {
		        ArrayList<Integer> subList = new ArrayList<Integer>();
		        for (Integer integer2 : list2) {
		            subList.add(integer2);
		        }
		        int max = Collections.max(subList);
		        int min = Collections.min(subList);
		        results.add(max-min);
		    }
		    System.out.println(Collections.min(results));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void recursion(ArrayList<Integer> notSmallestCombination) {
	    ArrayList<Integer> listTemp = (ArrayList<Integer>) notSmallestCombination.clone();
	    for (int i = 0; i < notSmallestCombination.size(); i++) {
	        listTemp.remove(i);
	        if (listTemp.size() == SIZE_OF_SUBARRAYS) {
	            for (int j = 0; j < notSmallestCombination.size(); j++) {
	                ArrayList<Integer> list2Temp = (ArrayList<Integer>) notSmallestCombination.clone();
	                list2Temp.remove(j);
	                set.add(list2Temp);
	            }
	        } else {
	            recursion(listTemp);
	        }
	        listTemp = (ArrayList<Integer>) notSmallestCombination.clone();
	    }
	}

}
