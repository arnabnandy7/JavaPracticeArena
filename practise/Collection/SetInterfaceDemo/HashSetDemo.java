package practise.Collection.SetInterfaceDemo;

import java.util.*;

public class HashSetDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> st = new HashSet<String>();
		
		System.out.println(st.add("Raj"));
		System.out.println(st.add("Rahul"));
		System.out.println(st.add("Ambu"));
		System.out.println(st.add("Nathan"));
		System.out.println(st.add("Raj"));
		//System.out.println(st.add(null));
		
		System.out.println("\tUsing Foreach Loop");
		for(String str:st) {
			System.out.println(str);
		}
		
		System.out.println("\tUsing Lambda Expression");
		
		st.forEach(str -> System.out.println(str));

		System.out.println("\tUsing Iterator");
		
		Iterator itr = st.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\tModifying using TreeSet\n");
		
		TreeSet< String> tset = new TreeSet<String>(st);
		System.out.println(tset);
		
	}

}
