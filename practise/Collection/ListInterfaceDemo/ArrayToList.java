package practise.Collection.ListInterfaceDemo;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Integer[] intArr = {1,2,3,4,5};
		System.out.println(Arrays.toString(intArr));
		
		
		
		List<Integer> intList = Arrays.asList(intArr);
	//	System.out.println(intList);

	}

}
