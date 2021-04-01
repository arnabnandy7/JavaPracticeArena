package test.codechef;

import java.util.Scanner;

public class MATXOR {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int i=0;i<tc;i++){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k=sc.nextInt();
			int xor=0;
			for(int j=1;j<=n;j++){
				for(int t=1;t<=m;t++){
					//System.out.println(k+" "+j+" "+t);
					xor = xor ^ (k+j+t);
				}
			}
			System.out.println(xor);
		}
		sc.close();
	}
}
