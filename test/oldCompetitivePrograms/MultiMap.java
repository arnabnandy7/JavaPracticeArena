package test.oldCompetitivePrograms;

import java.sql.Date;

import org.apache.commons.collections4.map.MultiKeyMap;

public class MultiMap {
	
	public static void main(String[] args) {
		Date pDate = new Date(2019, 31, 8);
		java.util.Date sDate = new Date(2019, 31, 8);
		MultiKeyMap<Comparable<?>, Comparable<?>> exampleMap=new MultiKeyMap<Comparable<?>, Comparable<?>>();
		exampleMap.put(25, "Name", "Account",pDate, "Kolkata", "R.Das");
		exampleMap.put(25, "Address", "Account",pDate, "Kolkata", "S.N.Colony");
		exampleMap.put(25, "Salary", "Account",pDate, "Kolkata", 10000);

		exampleMap.put(26, "Name", "Account",pDate, "Kolkata", "R.Tiwari");
		exampleMap.put(26, "Address", "Account",pDate, "Kolkata", "T.Marg");
		exampleMap.put(25, "Salary", "Account",pDate, "Kolkata", 20000);
		
		Object result = exampleMap.get(25,"Salary","Account",sDate,"Kolkata");
		int sal=Integer.parseInt(String.valueOf(result));
		result = exampleMap.get(25,"Address","Account",sDate, "Kolkata");
		String addr=result.toString();
		System.out.println(pDate+" "+sDate);
		
		System.out.println(sal+" "+addr);
		
	}

}
