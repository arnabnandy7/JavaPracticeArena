package practise.Java9.LambdaExprs;

import java.util.function.Consumer;

public class LambdaInference {
	public static void main(String[] args) {
		// *** Part 1 : identify the FI

		// Standard Syntax
		Consumer<String> c1 = msg -> System.out.println(msg.length());

		// Compile-time error: not enough info
		// Object x1=msg-> System.out.println(msg.length());

		// Compile-time error: not enough info
		// Object x2=(String msg)-> System.out.println(msg.length());

		// Ok:cast Added
		Object x3 = (Consumer<String>) ((String msg) -> System.out.println(msg
				.length()));

		// *** Part 2 : identify parameter types

		// Ok: but inferred parameter type is Object
		Consumer<?> c2 = msg -> System.out.println(msg);

		// Compile-time error: Inference in *not* based on body of lambda
		// Consumer<?> c3= msg -> System.out.println(msg.length());

		// Ok: Added manifest type to parameter
		Consumer<?> c4 = (String msg) -> System.out.println(msg.length());
	}

}
