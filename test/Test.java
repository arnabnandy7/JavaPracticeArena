package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Test1 {
	static boolean x;
	static boolean y;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(y && !x);
		System.out.println(x || y);
		x = x || y && !x;
		y = y && x || y;
		System.out.println(x);
		System.out.println(y);

	}
}

// class Test2 extends Thread {
// final StringBuffer sb1 = new StringBuffer();
// final StringBuffer sb2 = new StringBuffer();
//
// public static void main(String args[]) {
// final Test h = new Test();
// new Thread() {
// public void run() {
// synchronized (this) {
// h.sb1.append("Java");
// h.sb2.append("Thread");
// System.out.println(h.sb1);
// System.out.println(h.sb2);
// }
// }
// }.start();
// new Thread() {
// public void run() {
// synchronized (this) {
// h.sb1.append("Mutithreading");
// h.sb2.append("Example");
// System.out.println(h.sb2);
// System.out.println(h.sb1);
// }
// }
// }.start();
// }
// }

class sample {
	public int a;
	static int b;

	void cal(int m, int n) {
		a += m;
		b += n;
	}
}

class Test3 {
	public static void main(String args[]) {
		// sample obj1 = new sample();
		// sample obj2 = new sample();
		// obj1.a = 0;
		// obj1.b = 0;
		// obj1.cal(1, 2);
		// obj2.a = 0;
		// obj2.cal(2, 3);
		// System.out.println(obj1.a + " " + obj2.b);
		List<String> subList = permStr("CHAIR")
				.stream()
				.filter(p -> !p.startsWith("A") && !p.startsWith("E")
						&& !p.startsWith("I") && !p.startsWith("O")
						&& !p.startsWith("U")).collect(Collectors.toList());

		System.out.println(subList.size());
	}

	static List<String> permStr(String str) {

		if (str.length() == 1) {
			List<String> ret = new ArrayList<String>();
			ret.add(str);
			return ret;
		}

		char start = str.charAt(0);
		List<String> endStrs = permStr(str.substring(1));
		List<String> newEndStrs = new ArrayList<String>();
		for (String endStr : endStrs) {
			for (int j = 0; j <= endStr.length(); j++) {
				if (endStr.substring(0, j).endsWith(String.valueOf(start)))
					break;
				newEndStrs.add(endStr.substring(0, j) + String.valueOf(start)
						+ endStr.substring(j));
			}
		}
		return newEndStrs;
	}
}

public class Test 
{ 
	static Test t ; 
	
	static int count =0; 
	
	public static void main(String[] args) throws InterruptedException 
	{ 
		Test t1 = new Test(); 
			
		// making t1 eligible for garbage collection 
		t1 = null; // line 12 
			
		// calling garbage collector 
		System.gc(); // line 15 
			
		// waiting for gc to complete 
		Thread.sleep(1000); 
	
		// making t eligible for garbage collection, 
		t = null; // line 21 
			
		// calling garbage collector 
		System.gc(); // line 24 
	
		// waiting for gc to complete 
		Thread.sleep(1000); 
			
		System.out.println("finalize method called "+count+" times"); 
		
	} 
	
	@Override
	protected void finalize() 
	{ 
		count++; 
		
		t = this; // line 38 
			
	} 
	
}
