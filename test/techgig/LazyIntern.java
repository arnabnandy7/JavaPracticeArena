package test.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Passed two test cases only
public class LazyIntern {
	public static void main(String[] args) {
		// Write code here
		try {
			ArrayList<Integer> finDist = new ArrayList<Integer>();
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			char a[][] = new char[n][n];
			for (int i = 0; i < n; i++) {
				String x = sc.next();
				for (int j = 0; j < x.length(); j++) {
					a[i][j] = x.charAt(j);
				}
				x = sc.next();
				int k = 4;
				for (int j = 0; j < x.length(); j++) {
					a[i][k] = x.charAt(j);
					k++;
				}
			}
			int mI = 0, mJ = 0, vI = 0, vJ = 0, dist = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == 'M') {
						mI = i;
						mJ = j;
					}
					if (a[i][j] == 'V') {
						vI = i;
						vJ = j;
						if (mJ >= 4) {
							if (vJ >= 4)
								dist = Math.abs(mI - vI);
							else
								dist = Math.abs(mI - vI) + 2;
						} else {
							if (vJ >= 4)
								dist = Math.abs(mI - vI) + 2;
							else
								dist = Math.abs(mI - vI);
						}

						finDist.add(dist);
					}
				}
			}
			System.out.println(Collections.min(finDist));
			sc.close();
		} catch (Exception e) {

		}
	}
}
