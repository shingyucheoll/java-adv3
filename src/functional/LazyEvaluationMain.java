package functional;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationMain {

	static void main() {

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Stream<Integer> stream = numbers.stream()
			.filter(n -> {
				System.out.println("filter : " + n);
				return n % 2 == 0;
			});

		// 아직 아무 작업도 실행되지 않은 상태

		System.out.println("toList 실행");

		// 최종 연산을 호출할 때 실제 동작이 시작됨
		List<Integer> evens = stream.toList();

		System.out.println("evens = " + evens);

	}
}
