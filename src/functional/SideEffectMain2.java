package functional;

import java.util.function.Function;

public class SideEffectMain2 {

	static void main() {

		Function<Integer, Integer> func = x -> {
			int result = x * 2;
			// 부수 효과(Side Effect) => console 에 출력하는 동작도 부수효과로 판단합니다.
			// 외부 세계에 영향을 미치므로 순수 함수로 보기는 어렵지만, 이정도는 괜찮다
			System.out.println("x = " + x + ", result = " + (x * 2));
			return result;
		};

		func.apply(10);
		func.apply(10);
		func.apply(10);
		func.apply(10);




	}
}
