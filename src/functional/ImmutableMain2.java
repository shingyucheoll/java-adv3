package functional;

import java.util.List;

public class ImmutableMain2 {

	static void  main() {
		MutablePerson m1 = new MutablePerson("Kim", 10);
		MutablePerson m2 = new MutablePerson("Lee", 20);

		List<MutablePerson> originList = List.of(m1, m2);
		System.out.println("originList = " + originList);

		List<MutablePerson> resultList = originList.stream()
			.map(p -> {
				p.setAge(p.getAge() + 1);
				return p;
			})
			.toList();


		System.out.println("resultList = " + resultList);
		// originList (원본 객체)의 값이 변경됨
		System.out.println("originList = " + originList);
		// Mutable(가변) 상태는 이런식으로 예상치 못한 곳에 영향을 미치므로, 버그나 유지보수 어려움을 초래할 수 있습니다.






	}
}
