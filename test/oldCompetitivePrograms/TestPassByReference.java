package test.oldCompetitivePrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestPassByReference {
	private int a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPassByReference obj = new TestPassByReference();
		List<String> sample = new ArrayList<String>();
		obj.func1(sample);

		System.out.println(sample);

		TestPassByReference obj1 = new TestPassByReference();
		obj1.func3(obj1);

		System.out.println(obj1.a);

	}

	private void func1(List<String> param) {
		param.add("Hi");
		func2(param);
	}

	private void func2(List<String> param1) {
		param1.add("Hello");
	}

	private void func3(TestPassByReference param) {
		param.a = 1;
		func4(param);
	}

	private void func4(TestPassByReference param1) {
		param1.a = param1.a + 3;
	}

}
