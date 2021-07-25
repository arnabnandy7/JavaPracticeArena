package test.techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BiraGame {
	static int x = 0;

	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int b = sc.nextInt();
	    List<Integer> bira = new ArrayList<>(b);
	    int[] ppl = new int[sc.nextInt()];
	    for (int i = 0; i < b; i++) {
	      bira.add(sc.nextInt());
	    }
	    for (int i = 0; i < ppl.length; i++) {
	      ppl[i] = sc.nextInt();
	    }
	    Arrays.sort(ppl);
	    Collections.sort(bira);
	    System.out.print(find(bira, ppl, x));
	    sc.close();
	  }

	  static int find(List<Integer> bira, int[] ppl, int x) {
	    for (int i = ppl.length - 1; i >= 0; i--) {
	      for (int j = bira.size() - 1; j >= 0; j--) {
	        if (bira.get(j) <= ppl[i]) {
	          bira.remove(j);
	          break;
	        }
	      }
	    }
	    x++;
	    if (bira.size() > 0) {
	      x++;
	      x = find(bira, ppl, x);
	    }
	    return x;
	  }

}
