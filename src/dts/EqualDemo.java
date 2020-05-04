package dts;

public class EqualDemo {
	
	public static void main(String[] args) {
		Integer i=new Integer("10");
		int j=10;
		System.out.println(i==j);
		System.out.println(i.equals(j));
		
		String s=new String("abc");
		String a="abc";
		System.out.println(s==a);
		System.out.println(s.equals(a));
		// Both same value and referenced in same location
		System.out.println(s.hashCode()+" "+a.hashCode()); 
		
		String sObj = new String("xyz");
		String sObj1 = new String("xyz");
		System.out.println(sObj==sObj1);
		System.out.println(sObj.equals(sObj1));
		System.out.println(sObj.hashCode()+" "+sObj1.hashCode());
	}
}
