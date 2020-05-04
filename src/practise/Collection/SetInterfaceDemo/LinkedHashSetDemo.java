package practise.Collection.SetInterfaceDemo;

import java.util.*;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		Set<String> lst = new LinkedHashSet<String>();
		
		System.out.println(lst.add("Raj"));
		System.out.println(lst.add("Rahul"));
		System.out.println(lst.add("Ambu"));
		System.out.println(lst.add("Nathan"));
		System.out.println(lst.add("Raj"));
		System.out.println(lst.add(null));
		
		for(String str:lst) {
			System.out.println(str);
		}
		
		System.out.println(" Using Lambda Expression");
		
		lst.forEach(str -> System.out.println(str));

		System.out.println(" Using Iterator");
		
		Iterator itr = lst.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}

}
