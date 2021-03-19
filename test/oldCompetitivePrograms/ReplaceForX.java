package test.oldCompetitivePrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReplaceForX {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		if(T>=1 && T<=100){
			int sumOfN=0;
			for(int i=0;i<T;i++){
				int N=sc.nextInt();
				sumOfN+=N;
				int X=sc.nextInt();
				int p=sc.nextInt();
				int k=sc.nextInt();
				if(p>=1 && p<=N && k>=1 && k<=N && X>=0 && X<=1000000000){
					ArrayList<Integer> aI=new ArrayList<Integer>();
					for(int j=0;j<N;j++){
						int tempVar=sc.nextInt();
						if(tempVar>=0 && tempVar<=1000000000){
							aI.add(tempVar);
						}
					}
					Collections.sort(aI);
					if(aI.indexOf(X)==-1)
						System.out.println(aI.indexOf(X));
					else
					{
						int cur=aI.indexOf(X)+1;
						if(cur==p){
							System.out.println(0);
						}else{
							System.out.println(Math.abs(cur-p));
						}
					}
				}
			}
		}
		sc.close();
	}
}
