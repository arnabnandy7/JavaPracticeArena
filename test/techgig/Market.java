package test.techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Sample Input 1 : 
 4 49
 4 6 2 5
 Output 1 : 11

 Sample Input 2:
 5 24
 4 8 9 7 2
 Output 1 : 4
 */
public class Market {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		String[] firstLine = read.readLine().split(" ");
		int totalItemBuy = Integer.parseInt(firstLine[0]);
		int totalAmount = Integer.parseInt(firstLine[1]);
		String[] secondLine = read.readLine().split(" ");
		int[] prices = new int[totalItemBuy];
		for (int i = 0; i < totalItemBuy; i++) {
			prices[i] = Integer.parseInt(secondLine[i]);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		// System.out.println(getSumOfArr(prices, totalAmount, map));
		int preCheck = getSumOfArr(prices, totalAmount, map);
		// System.out.println(map.get("remain"));
		int output = preCheck
				+ getTotalByItem(prices, totalAmount - map.get("remain"));

		System.out.println(output);
	}

	static int getSumOfArr(int[] prices, int totalAmount,
			Map<String, Integer> map) {
		int sum = 0, tempSum = 0;
		int totalCnt = prices.length;
		for (int i : prices) {
			sum += i;
		}
		tempSum = sum;
		while (sum <= totalAmount) {
			sum += tempSum;
			totalCnt += prices.length;
		}
		if (sum > totalAmount && sum > 0) {
			sum -= tempSum;
			totalCnt -= prices.length;
		}
		map.put("remain", sum);
		return totalCnt;
	}

	static int getTotalByItem(int[] prices, int totalAmount) {
		int temp = 0;
		int count = 0;
		for (int i : prices) {
			if (temp > 0) {
				if (temp > i) {
					temp = temp - i;
					count = count + 1;
				}
			} else {
				if (count == 0) {
					temp = totalAmount - i;
					count = count + 1;
				}
			}
		}
		return count;
	}
}
