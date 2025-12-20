package functional;

import java.util.function.Function;

public class SideEffectMain3 {

	static void main() {

		// 외부 상태를 전혀 수정하지 않는 순수 함수 !
		Function<Integer, Integer> func = x -> x * 2;

		int x = 10;

		Integer result = func.apply(x);

		// 부수 효과는 순수 함수와 분리해서 실행
		System.out.println("x = " + x + ", result = " + result);




	}
}
