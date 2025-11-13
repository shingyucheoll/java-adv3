package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {

    static void main() {

        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // 1. filter
        System.out.println("1. filter - 짝수만 선택");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2. map
        System.out.println("2. map - 각 숫자를 제곱");
        numbers.stream()
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 3. distinct
        System.out.println("3. distinct - 중복 제거");
        numbers.stream()
            .distinct()
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 4. sorted
        System.out.println("4. sorted - 기본 정렬");
        Stream.of(1, 4, 6, 4, 5, 74, 1, 4, 3, 2, 1, 54)
            .sorted()
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 5. sorted 커스텀 정렬
        System.out.println("5. sorted - 커스텀 정렬");
        Stream.of(1, 4, 6, 4, 5, 74, 1, 4, 3, 2, 1, 54)
            .sorted(Comparator.reverseOrder())
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 6. peek - 연산에 영향을 끼치지 않으며 중간에 로그를 남길 수 있게 됩니다.
        System.out.println("6. peek - 동작 확인용");
        numbers.stream()
            .peek(n -> System.out.print("before : " + n + ", "))
            .map(n -> n * n)
            .peek(n -> System.out.print("after : " + n + ", "))
            .limit(5)
            .forEach(n -> System.out.println("최종값 : " + n));
        System.out.println("\n");

        // 7. limit
        System.out.println("7. limit - 처음 5개 요소만");
        numbers.stream()
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 8. skip
        System.out.println("8. skip - 처음 5개 요소를 건너뛰기");
        numbers.stream()
            .skip(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 9. takeWhile ( Java 9 + )  Predicate <? super Integer> predicate
        // 조건에서 false 를 만나게 되는 순간 작업을 중지합니다.
        // 특징으로는 정렬이 잘 된 리스트에서 사용하는게 좋습니다.
        // 중간에 스트림이 멈추기 때문에 원하는 목적을 빠르게 달성하면 성능 최적화가 가능합니다.
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("9. takeWhile - 5보다 작은 동안만 선택합니다.");
        numbers2.stream()
            .takeWhile(n -> n < 5)      // 조건이 true 인 경우 계속 실행되며, false 를 반환하면 즉시 중단
            .forEach(n -> System.out.print(n + " "));   // 결과 1, 2, 3, 4
        System.out.println("\n");

        // 10. dropWhile ( Java 9 + )  Predicate <? super Integer> predicate
        // takeWhile 과 같이 정렬된 스트림에서 사용할 때 유용합니다.
        System.out.println("10. dropWhile - 5보다 작은 동안 건너뛰기");
        numbers2.stream()
            .dropWhile(n -> n < 5)  // 조건이 true 인 경우 무시하고, false 를 반환하면 그때부터 반환
            .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

    }
}
