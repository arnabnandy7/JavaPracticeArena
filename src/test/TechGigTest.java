package test;

import java.io.*;
import java.util.*;

class TechGigTest {
	BufferedReader in;
	StringTokenizer st;

	public static void print(Integer arg) {
		System.out.print("Integer");
	}

	public void print(int arg) {
		System.out.print("int");
	}

	public static void main(String[] args) {

		print(new Integer(3));
	}

	/*
	 * public static void main(String args[]) throws Exception { Scanner sc =
	 * new Scanner(System.in); // Write code here int T, N;
	 * 
	 * T = sc.nextInt();
	 * 
	 * if (T >= 1 && T <= 100000) { for (int tCase = 0; tCase < T; tCase++) { N
	 * = sc.nextInt(); if (N >= 1 && N <= 100000) { ArrayList<Long> gRevTeam =
	 * new ArrayList<Long>(); ArrayList<Long> aStarTeam = new ArrayList<Long>();
	 * for (int mem = 0; mem < N; mem++) { long power = sc.nextLong(); if (power
	 * >= 0l && power <= Long.MAX_VALUE) { gRevTeam.add(power); } }
	 * 
	 * for (int mem = 0; mem < N; mem++) { long power = sc.nextLong(); if (power
	 * >= 0l && power <= Long.MAX_VALUE) { aStarTeam.add(power); } }
	 * 
	 * Collections.sort(gRevTeam);
	 * 
	 * for (int mem = 0; mem < N; mem++) { if (gRevTeam.get(mem) >
	 * Collections.min(aStarTeam)) { removeLostBayblade(aStarTeam,
	 * Collections.min(aStarTeam)); } }
	 * 
	 * System.out.println((N - aStarTeam.size())); } } }
	 * 
	 * } }
	 */

	/*
	 * public static void main(String[] args) { // Scanner sc = new
	 * Scanner(System.in); ArrayList<Long> gRevTeam = new ArrayList<Long>();
	 * ArrayList<Long> aStarTeam = new ArrayList<Long>();
	 * 
	 * gRevTeam.add(3l); gRevTeam.add(6l); gRevTeam.add(7l); gRevTeam.add(5l);
	 * gRevTeam.add(3l); gRevTeam.add(5l); gRevTeam.add(6l); gRevTeam.add(2l);
	 * gRevTeam.add(9l); gRevTeam.add(1l);
	 * 
	 * aStarTeam.add(2l); aStarTeam.add(7l); aStarTeam.add(0l);
	 * aStarTeam.add(9l); aStarTeam.add(3l); aStarTeam.add(6l);
	 * aStarTeam.add(0l); aStarTeam.add(6l); aStarTeam.add(2l);
	 * aStarTeam.add(6l);
	 * 
	 * int T, N;
	 * 
	 * // T = sc.nextInt(); T = 1;
	 * 
	 * if (T >= 1 && T <= 100000) { for (int tCase = 0; tCase < T; tCase++) { //
	 * N = sc.nextInt(); N = 10; if (N >= 1 && N <= 100000) {
	 * 
	 * for (int mem = 0; mem < N; mem++) { long power = sc.nextLong(); if (power
	 * >= 0l && power <= Long.MAX_VALUE) { gRevTeam.add(power); } }
	 * 
	 * for (int mem = 0; mem < N; mem++) { long power = sc.nextLong(); if (power
	 * >= 0l && power <= Long.MAX_VALUE) { aStarTeam.add(power); } }
	 * 
	 * 
	 * Collections.sort(gRevTeam);
	 * 
	 * for (int mem = 0; mem < N; mem++) {
	 * if(gRevTeam.get(mem)>Collections.min(aStarTeam)){
	 * removeLostBayblade(aStarTeam, Collections.min(aStarTeam)); } }
	 * 
	 * System.out.println(N-aStarTeam.size()); } } }
	 * 
	 * }
	 */

	public static ArrayList<Long> getDeprecPrice(ArrayList<Long> priceList) {
		ArrayList<Long> depPriceList = new ArrayList<Long>();
		for (Long tempPrice : priceList) {
			if (tempPrice > 0l)
				depPriceList.add(tempPrice - 1);
			else
				depPriceList.add(tempPrice);
		}
		return depPriceList;
	}

	public static ArrayList<Long> removeLostBayblade(ArrayList<Long> aStarTeam,
			Long aStarPower) {
		Long occurrences = Collections.frequency(aStarTeam, aStarPower) - 1l;
		aStarTeam.removeAll(Collections.singleton(aStarPower));
		for (Long totl = 0l; totl < occurrences; totl++) {
			aStarTeam.add(aStarPower);
		}
		return aStarTeam;
	}

	/*
	 * public static void main(String[] args) { // new ProblemC();
	 * //System.out.println(isAnagram("LION", "TIGER"));
	 * //System.out.println(getHighestPoint(2, 20)); }
	 */

	public static long getHighestPoint(long qtyOfIgt, long totalIgt) {
		long cnt = 1l;

		while ((qtyOfIgt * cnt) < totalIgt) {
			System.out.println((qtyOfIgt * cnt) + " -- " + totalIgt + " -- "
					+ cnt);
			cnt++;
		}

		return cnt;
	}

	public static boolean isAnagram(String str1, String str2) {
		String s1 = str1.replaceAll("\\s", "");
		String s2 = str2.replaceAll("\\s", "");
		boolean status = true;
		if (s1.length() != s2.length()) {
			status = false;
		} else {
			char[] ArrayS1 = s1.toLowerCase().toCharArray();
			char[] ArrayS2 = s2.toLowerCase().toCharArray();
			Arrays.sort(ArrayS1);
			Arrays.sort(ArrayS2);
			status = Arrays.equals(ArrayS1, ArrayS2);
		}
		if (status)
			return true;
		else
			return false;
	}

	public int minCost(int[][] arr1, int[][] arr2) {
		int cost = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				cost += Math.abs(arr1[x][y] - arr2[x][y]);
			}
		}
		return cost;
	}

	public void ProblemC() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			int[][] arr = new int[3][3];
			for (int y = 0; y < 3; y++)
				for (int x = 0; x < 3; x++)
					arr[x][y] = nextInt();

			int[][] arr1 = new int[][] { { 8, 1, 6, }, { 3, 5, 7, },
					{ 4, 9, 2, }, };

			int[][] arr2 = new int[][] { { 6, 1, 8, }, { 7, 5, 3, },
					{ 2, 9, 4, }, };

			int[][] arr3 = new int[][] { { 4, 9, 2, }, { 3, 5, 7, },
					{ 8, 1, 6, }, };

			int[][] arr4 = new int[][] { { 2, 9, 4, }, { 7, 5, 3, },
					{ 6, 1, 8, }, };

			int[][] arr6 = new int[][] { { 8, 3, 4, }, { 1, 5, 9, },
					{ 6, 7, 2, }, };

			int[][] arr7 = new int[][] { { 4, 3, 8, }, { 9, 5, 1, },
					{ 2, 7, 6, }, };

			int[][] arr8 = new int[][] { { 6, 7, 2, }, { 1, 5, 9, },
					{ 8, 3, 4, }, };

			int[][] arr9 = new int[][] { { 2, 7, 6, }, { 9, 5, 1, },
					{ 4, 3, 8, }, };
			int ans = Integer.MAX_VALUE;
			ans = Math.min(ans, minCost(arr, arr1));
			ans = Math.min(ans, minCost(arr, arr2));
			ans = Math.min(ans, minCost(arr, arr3));
			ans = Math.min(ans, minCost(arr, arr4));
			// ans = Math.min(ans, minCost(arr, arr5));
			ans = Math.min(ans, minCost(arr, arr6));
			ans = Math.min(ans, minCost(arr, arr7));
			ans = Math.min(ans, minCost(arr, arr8));
			ans = Math.min(ans, minCost(arr, arr9));
			System.out.println(ans);
		} catch (IOException e) {
			System.out.println("IO: General");
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine().trim());
		return st.nextToken();
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	String nextLine() throws IOException {
		return in.readLine().trim();
	}
}