package practise.Collection.ListInterfaceDemo;

import java.util.*;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack <String> stk = new Stack<String>();
		stk.push("Satya");
		stk.push("Raj");
		stk.push("Rahul");
		stk.push("Satya");
		stk.push("Rohan");
		
		for(String str : stk) {
			
			System.out.println(str);
			
		}
		
		System.out.println("\n Peeking through Stack:-"+stk.peek());
		
		System.out.println("The full Stack is: "+stk);
		
		stk.pop();
		stk.pop();
		//stk.removeElementAt(2);
		
		System.out.println("The full Stack is: "+stk);
		

	}	
	

}
