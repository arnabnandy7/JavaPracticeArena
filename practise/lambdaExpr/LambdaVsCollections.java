package practise.LambdaExpr;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaVsCollections {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Paul", "Jane", "Micheala", "Sam");
		// way to sort prior to Java 8 lambdas
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		
		// first iteration with lambda
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		
		// now remove the data types and allow the compile to infer the type
		Collections.sort(names, (a, b) -> b.compareTo(a));
		
		// total pages in your book collection
	}
}
