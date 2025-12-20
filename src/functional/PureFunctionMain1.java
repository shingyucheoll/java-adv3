package functional;

import java.util.function.Function;

public class PureFunctionMain1 {

	static void main() {

		Function<Integer, Integer> func = x -> x * 2;
		System.out.println("result1 = " + func.apply(10));
		System.out.println("result2 = " + func.apply(10));
		System.out.println("result3 = " + func.apply(10));
		System.out.println("result4 = " + func.apply(10));
		System.out.println("result5 = " + func.apply(10));
		System.out.println("result6 = " + func.apply(10));
		System.out.println("result7 = " + func.apply(10));
		System.out.println("result8 = " + func.apply(10));
	}
}
