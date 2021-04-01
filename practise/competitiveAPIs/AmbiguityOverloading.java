package practise.CompetitiveAPIs;

public class AmbiguityOverloading {
	
	public void test1(String s){
		System.out.println(s);
	}
	
	public void test1(Integer i){
		System.out.println(i);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AmbiguityOverloading ao=new AmbiguityOverloading();
		//ao.test1(null);	// It'll throw error
	}
}
