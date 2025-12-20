package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {

	static void main() {

		List<String> list1 = new ArrayList<>();
		list1.add("apple");
		list1.add("orange");

		System.out.println("before list1 = " + list1);

		// 인자값으로 사용된 list 의 상태가 변경되는 부수 효과를 일으킵니다.
		changeList1(list1);

		System.out.println("after list1 = " + list1);

		List<String> list2 = new ArrayList<>();
		list2.add("apple");
		list2.add("orange");

		System.out.println("before list2 = " + list2);

		// 원본이 그대로 유지되기 때문에 부수 효과가 없는 메서드입니다.
		// 함수형 프로그래밍에서 지향하는 순수 함수, 부수 효과 '최소화' 와 적합한 예제입니다.
		List<String> result = changeList2(list2);

		System.out.println("result = " + result);
		System.out.println("after list2 = " + list2);

	}


	private static void changeList1(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) + "_complete");
		}
	}

	private static List<String> changeList2(List<String> list) {
		List<String> newList = new ArrayList<>();

		for (String s : list) {
			newList.add(s + "_complete");
		}

		return newList;


	}
}
