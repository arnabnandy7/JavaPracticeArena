package practise.Collection.ListInterfaceDemo;

import java.util.*;

public class ReverseArrayListExp {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> alt = new ArrayList<String>();
		
		alt.add("Dhoni");
		alt.add("Sachin");
		alt.add("Rahul");
		alt.add("Dhoni");
		alt.add("Kohli");
		
		/* Iteration */

		for(String str : alt) {
			
			System.out.println(str);
			
		}
		
		System.out.println("\n Using Iterator \n");
		Iterator itr = alt.iterator();
		
		while (itr.hasNext()) {
			
			String s = (String) itr.next();
			System.out.println(s);
			
		}
		
//		alt.removeAll(null);
//		System.out.println(alt);
	
//		System.out.println("\n Sorting \n");
//
//		Collections.sort(alt);
//		System.out.println(alt);
//		
//		
		System.out.println("\n Reversing ArrayList :-");
		
		Collections.reverse(alt);
		System.out.println(alt);

		
	}

}
