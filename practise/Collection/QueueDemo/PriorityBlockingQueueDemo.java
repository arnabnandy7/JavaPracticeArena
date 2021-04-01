package practise.Collection.QueueDemo;

import java.util.*;
import java.util.concurrent.*;

public class PriorityBlockingQueueDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue();
		
		pbq.put("Amit");
		pbq.put("Prafulla");
		pbq.put("Amit");
		pbq.put("Rahul");
		pbq.put("Nitin");
		pbq.put("Kamal");
		
		for(String str:pbq) {
			System.out.println(str);
		}
		
		System.out.println(" Using Iterator");
		
		Iterator itr = pbq.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(" Using Lambda Expression");
		
		pbq.forEach(str -> System.out.println(str));
		
		System.out.println(" Deleting");
		
		while(pbq.take()!=null) {
			System.out.println(pbq);
		}
		
				
	}
}
