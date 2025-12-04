package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    static void main() {

        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // ifPresent() : 값이 있으면 Consumer 실행, 없으면 아무 행동도 하지 않습니다.
        optValue.ifPresent(v -> System.out.println("optValue 값 : " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값 : " + v));   // 실행되지 않음

        // ifPresentOrElse() : 값이 있으면 Consumer 실행 없으면 Runnable 실행
        optValue.ifPresentOrElse(
            v -> System.out.println("optValue 값이 있을 경우 실행 v = " + v),
                () -> System.out.println("optValue 값이 비어있을 경우 실행")
        );

        optEmpty.ifPresentOrElse(
            v -> System.out.println("optEmpty 값이 있을 경우 실행 v = " + v),
            () -> System.out.println("optEmpty 값이 비어있을 경우 실행")
        );

        // map() : 값이 있으면 Function 적용 후 Optional 로 반환, 없으면 Optional.empty() 반환
        Optional<Integer> optValueLength1 = optValue.map(String::length);
        System.out.println("optValueLength1 = " + optValueLength1);

        Optional<Integer> optEmptyLength1 = optEmpty.map(String::length);
        System.out.println("optEmptyLength1 = " + optEmptyLength1);

        // flatMap : Optional 을 반환하는 경우 중첩을 제거해서 평탄화 시킨 후 반환합니다. ( Optional[Optional[]] 일때 -> Optional[] )
        Optional<Optional<Integer>> nestedOpt = optValue.map(s -> Optional.of(s.length()));
        // Optional[Optional[5]] 이렇게 반환됨
        System.out.println("nestedOpt = " + nestedOpt);

        Optional<Integer> flattenedOpt = optValue.flatMap(s -> Optional.of(s.length()));
        System.out.println("flattenedOpt = " + flattenedOpt);

        // filter() : 값이 있고 조건을 만족할 경우 그 값을 그대로 반환하며 없을 경우 Optional.empty() 반환
        Optional<String> valueFiltered1 = optValue.filter(s -> s.startsWith("H"));
        System.out.println("valueFiltered1 = " + valueFiltered1); // Optional[Hello]

        Optional<String> valueFiltered2 = optValue.filter(s -> s.startsWith("X"));
        System.out.println("valueFiltered2 = " + valueFiltered2); // Optional.empty

        Optional<String> emptyFiltered1 = optEmpty.filter(s -> s.startsWith("X"));
        System.out.println("emptyFiltered1 = " + emptyFiltered1);

        // stream() : 값이 있으면 단일 요소 스트림, 없으면 빈 스트림

        // 값이 있는경우 stream() 실행됨
        optValue.stream()
            .forEach(s -> System.out.println("optValue.stream() -> " + s));

        // 값이 없으면 빈 스트림을 반환하여 아무 작업도 진행하지 않습니다.
        optEmpty.stream()
            .forEach(s -> System.out.println("optEmpty.stream() -> " + s));


    }
}
