package test.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 //imports for BufferedReader
 import java.io.BufferedReader;
 import java.io.InputStreamReader;

 //import for Scanner and other utility classes
 import java.util.*;
 */
import java.io.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass1 {
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); String name =
		 * s.nextLine(); // Reading input from STDIN System.out.println("Hi, " +
		 * name + "."); // Writing output to STDOUT
		 */

		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		String line;
		int l;
		char ch = 0, nxt = 0;
		StringBuilder sb;
		while ((line = br.readLine()) != null) {
			l = line.length();
			sb = new StringBuilder();
			if (l > 0) {
				int i;
				for (i = 0; i < l - 1; i++) {
					ch = line.charAt(i);
					nxt = line.charAt(i + 1);
					if (ch == 47 && nxt == 47) {
						sb.append(line.substring(i, line.length()));
						break;
					} else if (ch == 45 && nxt == 62) {
						sb.append(".");
						i++;
					} else
						sb.append(ch);

				}
				if (!(i < l - 1 || (line.charAt(l - 1) == 62 && l > 1 && line
						.charAt(l - 2) == 45)))
					sb.append(line.charAt(l - 1));
			}
			out.println(sb.toString());
			out.flush();
		}
		out.close();
	}
}