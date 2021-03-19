package practise.Collection.ListInterfaceDemo;

import java.util.*;

public class LinkedListDemo {

	public static void main (String[] arg) {
		List ld = new LinkedList<>();
		ld.add("Chitradeep");
		ld.add(1);
		ld.add("Debloy");
		ld.add(2);
		ld.add(null);
		
		for(int i=0;i<ld.size();i++) {
			System.out.println(ld.get(i));
		}
		
		
		System.out.println(" Iterator");
		
		Iterator itr = ld.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//ld.remove("Debloy");
		
		
		System.out.println(ld);
		
		System.out.println(" Lamda");
		
		ld.forEach(lds -> System.out.println(lds));
		
		System.out.println("List Iterator ");
		
		ListIterator ltr = ld.listIterator();
		
		while (ltr.hasPrevious()) {
			
			System.out.println(ltr.previous());
		}
		
		while (ltr.hasNext()) {
			
			System.out.println(ltr.next());
		}
	
	}
}
