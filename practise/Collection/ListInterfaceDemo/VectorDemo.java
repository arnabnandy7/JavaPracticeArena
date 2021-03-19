package practise.Collection.ListInterfaceDemo;

import java.util.*;

public class VectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector <String> vec = new Vector<String>();
		vec.addElement("Satya");
		vec.addElement("Raj");
		vec.addElement("Rahul");
		vec.addElement("Satya");
		vec.addElement("Rohan");
		
		for(String str : vec) {
			
			System.out.println(str);
		}
		
		vec.removeElement("Satya");
		System.out.println(vec);

	}	
	

}
