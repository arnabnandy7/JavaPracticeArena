package test.techgig;

import java.util.*;

public class SaveTheCity {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		if (tc >= 1 && tc <= 10) {
			for (int i = 0; i < tc; i++) {
				String str = sc.nextLine();
				System.out.println(str);
				if (str.length() >= 1 && str.length() <= 100000) {
					List<Character> chArr = findDuplicates(str);
					if (!chArr.isEmpty()) {
						Collections.sort(chArr);
						System.out.println(chArr.get(0));
					}
				}
			}
		}
		sc.close();
	}

	public static List<Character> findDuplicates(String str) {
		char[] carray = str.toCharArray();
		List<Character> rtn = new ArrayList<>();
		System.out.println(getMaxOccuringChar(str));

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (carray[i] == carray[j]) {
					// System.out.print(carray[j] + " ");
					rtn.add(carray[j]);
					break;
				}
			}
		}
		return rtn;
	}
	
	static char getMaxOccuringChar(String str)
    {
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[256];
      
        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;
      
        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result
      
        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
      
        return result;
    }
}
