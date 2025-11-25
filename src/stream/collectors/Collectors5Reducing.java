package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

// Reducing 이란 값을 줄여 나가는것을 의미합니다.
public class Collectors5Reducing {

    static void main() {
        List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");

        // 모든 이름을 하나의 문자열로 이어 붙입니다.
        String joined1 = names.stream()
            .collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2))
            .get();
        System.out.println("joined1 = " + joined1);

        // collect 를 사용하지 않고 바로 reduce 사용 가능
        String joined2 = names.stream()
            .reduce((s1, s2) -> s1 + ", " + s2).get();
        System.out.println("joined2 = " + joined2);

        // 문자열 전용 기능
        String joined3 = names.stream()
            .collect(Collectors.joining(", ")); // delimiter
        System.out.println("joined3 = " + joined3);

        // String 자체적으로 지원하기 때문에 보통 위 내용은 잘 사용되지 않습니다.
        String joined4 = String.join(", ", names);
        System.out.println("joined4 = " + joined4);

    }
}
