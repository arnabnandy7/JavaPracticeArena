package practise.Collection.QueueDemo;

import java.util.*;
import java.util.concurrent.*;

public class LinkedBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue lbq = new LinkedBlockingQueue<>();
		
		lbq.put("Amit");
		lbq.put("Charlie");
		lbq.put("Amit");
		lbq.put("Sumon");
		lbq.put("Saikat");
		
		for(Object obj:lbq) {
			System.out.println(obj);
		}
		
		System.out.println(" Using Iterator");
		
		Iterator itr = lbq.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(" Using Lambda Expression");
		
		lbq.forEach(str -> System.out.println(str));
		
		System.out.println(" Deleting");
		
		while(lbq.take()!=null) {
			System.out.println(lbq);
		}
	}
}
