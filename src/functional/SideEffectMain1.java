package functional;

import java.util.function.Function;

public class SideEffectMain1 {

	public static int count = 0;

	static void main() {

		// Side Effect 가 발생하는 함수 예제 -> 외부 상태가 변경되는 부수 효과의 대표적인 예시

		// 이러한 함수는 순수한 함수가 아니며 ( 외부의 상태값을 변경하기 때문에 )

		// 외부 상태 변경을 최소화 하는 것을 권장합니다.

		System.out.println("before count = " + count);

		Function<Integer, Integer> func = x -> {
			count++;
			return x * 2;
		};

		func.apply(10);

		System.out.println("after count = " + count);



	}
}
