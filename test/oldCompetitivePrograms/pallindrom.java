package test.oldCompetitivePrograms;

import java.util.Scanner;

public class pallindrom {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String args[] ) throws Exception {
	      int cnt = 0; 
	      int flag = 0; 

	      Scanner sc=new Scanner(System.in);
	      int N=sc.nextInt();
	      if(N>=3 && N<=5000){
	         String s=sc.next();
	         System.out.println(findMinInsertions(s.toCharArray(), 0, s.length()-1)); 
	      }
	   }

	   static int findMinInsertions(char str[], int l, int h) 
	   {  
	      if (l > h) return Integer.MAX_VALUE; 
	      if (l == h) return 0; 
	      if (l == h - 1) return (str[l] == str[h])? 0 : 1; 
	      
	      return (str[l] == str[h])? 
	         findMinInsertions(str, l + 1, h - 1): 
	         (Integer.min(findMinInsertions(str, l, h - 1), 
	         findMinInsertions(str, l + 1, h)) + 1); 
	   } 
}
