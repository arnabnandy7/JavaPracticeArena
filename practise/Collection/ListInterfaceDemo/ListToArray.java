package practise.Collection.ListInterfaceDemo;

import java.util.*;

public class ListToArray {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList ar = new ArrayList<>();
		ar.add("apple");
		ar.add("samsung");
		ar.add(null);
		ar.add("mi");
		ar.add("moto");
		
		System.out.println(ar);
		
		String[] str = (String[]) ar.toArray(new String[ar.size()]);
		System.out.println(Arrays.toString(str));
		

	}

}
