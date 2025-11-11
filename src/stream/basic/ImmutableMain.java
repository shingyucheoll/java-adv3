package stream.basic;

import java.util.List;

public class ImmutableMain {

    static void main() {
        List<Integer> originList = List.of(1, 2, 3, 4);
        System.out.println("originList = " + originList);

        List<Integer> filteredList = originList.stream()
            .filter(value -> value % 2 == 0)
            .toList();
        System.out.println("filteredList = " + filteredList);
        // 원본 데이터는 변경되지 않습니다.
        System.out.println("originList = " + originList);

    }
}
