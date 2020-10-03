package practise.CompetitiveAPIs;

public class CovidRun {
	public static void main(String[] args) {
		System.out.println(determineReach(6, 2, 5, 3));
		System.out.println(determineReach(1000, 1, 4, 2));
		System.out.println(determineReach(12, 3, 4, 4));
	}
	
	public static String determineReach(long N, long K, long X, long Y){
		String result="NO";
		long nextCity=X+K;
		if(X==Y){
			return "YES";
		}else{
			while(nextCity!=X){
				System.out.println(nextCity);
				if(nextCity==Y){
					result="YES";
					break;
				}
				nextCity+=K;
				if(nextCity>N)
					nextCity-=N;
			}
		}
		return result;
	}
}
