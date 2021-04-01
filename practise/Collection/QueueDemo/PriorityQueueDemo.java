package practise.Collection.QueueDemo;

import java.util.*;

public class PriorityQueueDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue();
		
		pq.offer("Hari");
		pq.offer("Amit");
		pq.offer("Raj");
		pq.offer("Hari");
		pq.offer("Rahul");
		
		for(String str: pq) {
			System.out.println(str);
		}
		
		
		System.out.println(" Using Iterator");
		
		Iterator itr = pq.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(" Using Lambda Expression");
		
		pq.forEach(str -> System.out.println(str));
		
		System.out.println(" Peeking " + pq.peek());
		
		System.out.println(pq);
		
		System.out.println(" Peeking " + pq.poll());
		
		System.out.println(pq);
		
		while(pq.poll()!=null) {
			System.out.println(pq);
		}
	}

}
