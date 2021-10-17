package test.prepBytes;

import java.util.Scanner;

/*
 2
 hshshbFGFDHKJS#%#23$FDD
 GSgs#FS@)bg555FH
 */
public class SecretCode {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			int i = 0;
			while (t > i) {
				System.out.println(sc.next().replaceAll("[^A-Z0-9]", ""));
				i++;
			}
			sc.close();
		} catch (Exception e) {
		}
	}
}
