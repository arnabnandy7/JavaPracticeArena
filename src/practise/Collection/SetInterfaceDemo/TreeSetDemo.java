package practise.Collection.SetInterfaceDemo;

import java.util.*;

public class TreeSetDemo {

	public static void main(String[] args) {
		Set<String> tst = new TreeSet<String>();
		
		System.out.println(tst.add("Raj"));
		System.out.println(tst.add("Rahul"));
		System.out.println(tst.add("Ambu"));
		System.out.println(tst.add("Nathan"));
		System.out.println(tst.add("Raj"));
		
		for(String str:tst) {
			System.out.println(str);
		}
		
		System.out.println(" Using Lambda Expression");
		
		tst.forEach(str -> System.out.println(str));

		System.out.println(" Using Iterator");
		
		Iterator itr = tst.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(tst);
		TreeSet temp_tset = (TreeSet) tst;
		System.out.println(temp_tset.descendingSet());
	}

}
