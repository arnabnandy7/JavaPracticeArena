package test.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VirusOutbreak {
	static List<String> al = new ArrayList<>();

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		// Write code here
		Scanner sc = new Scanner(System.in);
		String V = sc.nextLine();
		int N = sc.nextInt();

		if (N >= 1 && N <= 10 && V.length() >= 1 && V.length() <= 100000) {
			for (int i = 0; i <= N; i++) {
				String B = sc.nextLine();
				if (B.length() >= 1 && B.length() <= 100000) {
					// System.out.println(V+"::"+B);
					if (checkSubSequence(V, B))
						System.out.println("POSITIVE");
					else
						System.out.println("NEGATIVE");
				}
			}
		}
		sc.close();
	}

	@SuppressWarnings("unused")
	private static void findsubsequences(String s, String ans) {
		if (s.length() == 0) {
			al.add(ans);
			return;
		}

		findsubsequences(s.substring(1), ans + s.charAt(0));

		findsubsequences(s.substring(1), ans);
	}
	
	public static boolean checkSubSequence(String A, String B){
        if(A==null || B==null)
            return false;

        String longer = A.length()>B.length() ? A : B;
        String shorter = A.length()<=B.length() ? A : B;

        int j = 0;
        for (int i = 0; i < longer.length() && j < shorter.length(); i++) {
            if (longer.charAt(i) == shorter.charAt(j))
                j++;
        }

        //check if all are matched
        if(j==shorter.length())
            return true;

        return false;
    }
}
