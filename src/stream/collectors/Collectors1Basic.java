package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {

    static void main() {


        // 기본 기능
        List<String> list = Stream.of("Java, Spring, JPA").collect(Collectors.toList());    // toList() 로 생략 가능 Java16+

        System.out.println("list = " + list);

        // 수정 불가능한 리스트
        List<Integer> unmodifiableList = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());
        // unmodifiableList.add("hello");  추가 불가능! - 런타임 예외
        System.out.println("unmodifiableLIst = " + unmodifiableList);

        // set 은 중복된 데이터가 존재할 수 없는 자료 구조
        Set<Integer> set = Stream.of(1, 2, 2, 3, 3, 3)
            .collect(Collectors.toSet());
        System.out.println("set = " + set);

        // 타입을 지정 가능하다
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 6, 1, 2, 3)
            .collect(Collectors.toCollection(TreeSet::new));    // TreeSet 은 오름차순
        System.out.println("treeSet = " + treeSet);




    }


}
