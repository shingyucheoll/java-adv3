package stream.basic;

import java.util.List;
import java.util.stream.Stream;

// 같은 내용을 두 번 작업
public class DuplicateExecutionMain {

    static void main() {
        // 스트림 중복 실행 확인

        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.forEach(System.out::println);

        /*
        스트림은 일회성 특징을 가지기 때문에 예외 발생
        Exception in thread "main"
        java.lang.IllegalStateException: stream has already been operated upon or closed - 이미 사용되어 닫힘
         */
        // stream.forEach(System.out::println);

        // 대안 : 대상 리스트를 스트림으로 새로 생성해서 사용합니다.
        List<Integer> list = List.of(1, 2, 3);
        // Stream.of 를 사용해서 리스트를 스트림으로 새로 생성해서 사용합니다.
        Stream.of(list).forEach(System.out::println);
        Stream.of(list).forEach(System.out::println);



    }
}
