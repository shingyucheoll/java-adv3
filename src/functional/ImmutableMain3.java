package functional;

import java.util.List;

public class ImmutableMain3 {

	static void  main() {
		ImmutablePerson m1 = new ImmutablePerson("Kim", 10);
		ImmutablePerson m2 = new ImmutablePerson("Lee", 20);

		List<ImmutablePerson> originList = List.of(m1, m2);
		System.out.println("originList = " + originList);

		List<ImmutablePerson> resultList = originList.stream()
			.map(p -> p.withAge(p.getAge() + 1))
			.toList();


		System.out.println("resultList = " + resultList);
		// 실행 이후에도 원본 객체는 그대로 유지됩니다.
		// 이러한 형태가 Immutable State 지향에 대한 올바른 예 입니다.
		System.out.println("originList = " + originList);






	}
}
