package practise.Thread;

public class ThreadSample implements Runnable {

	public static void main(String[] args) {
		Thread t=new Thread();
		t.start();
		t.run();
	}
	
	public void run(){
		System.out.println("Hello");
	}

}
