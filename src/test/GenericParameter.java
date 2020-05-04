package test;

import java.util.*;


public class GenericParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list=test1(list);
		System.out.println(list);

	}
	
	public static List test1(List x){
		x.add(1);
		return x;
	}
	
	/*public static List<String> test1(List<String> x){
		x.add(1);
		return x;
	}*/

}
