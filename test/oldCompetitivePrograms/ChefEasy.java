package test.oldCompetitivePrograms;

import java.util.Scanner;

public class ChefEasy {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long T;
		T=sc.nextLong();
		long x=0;
		while(x<T){
			long count=0;
			int n=sc.nextInt();
			int k=sc.nextInt();
			long[] q=new long[n];
			for(int i=0;i<n;i++){
				q[i]=sc.nextLong();
			}
			int i;
			for(i=0;i<n;i++){
				if(q[i]>=k){
					count++;
					q[i+1]+=(q[i]-k);
				}
				if(q[i]<k)
					break;
			}
			if(i==n)
				count+=((q[n-1]-k)/k);
			System.out.println(count+1);
			x++;
		}
		sc.close();
	}
}
