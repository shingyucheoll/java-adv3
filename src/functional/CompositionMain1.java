package functional;

import java.util.function.Function;

public class CompositionMain1 {

	static void main() {
		// 1. x를 입력받아 x * x 하는 함수
		Function<Integer, Integer> square = x -> x * x;

		// 2. x를 입력받아 x + 1 하는 함수
		Function<Integer, Integer> add = x -> x + 1;

		// 함수 합성 Function.compose(Function)
		// 1. compose()를 사용한 새로운 함수 생성
		// square(add(2))  ->  square(3)  ->  9
		Function<Integer, Integer> newFunc1 = square.compose(add);
		// 내부에 선언된 함수부터 실행되기 때문에 결과값은 5가 아닌 9가 된다.  
		System.out.println("newFunc1 = " + newFunc1.apply(2));
		
		// 2. andThen()을 사용한 새로운 함수 생성
		// andThen 앞에 선언된 Function이 먼저 실행되고, 그 다음 andThen의 인자로 사용된 함수를 실행합니다.
		// add(square(2)) -> add(4) -> 5
		Function<Integer, Integer> newFunc2 = square.andThen(add);
		System.out.println("newFunc2.apply(2) = " + newFunc2.apply(2));

		// default Method로 제공하기 때문에 필요 시 가져다 사용 가능합니다.
		// compose(): 뒤쪽 함수 -> 앞쪽 함수 순으로 실행
		// andThen(): 앞쪽 함수 -> 뒤쪽 함수 순으로 실행

	}
}
