package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {

    static void main() {
        System.out.println("1. 컬렉션으로부터 생성");
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        System.out.println("2. 배열로부터 생성");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::println);

        System.out.println("3. Stream.of() 사용");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.forEach(System.out::println);

        // 계속 값을 제공해준다
        System.out.println("4. 무한 스트림 생성 - iterate()");

        // iterate : 초기값과 다음값을 만드는 함수를 지정합니다.
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);

        // 계속 출력...!!
        // infiniteStream.forEach(System.out::println);

        // limit() 을 사용해서 반복 횟수 제어 가능
        infiniteStream.limit(5).forEach(System.out::println);

        // Supplier 를 사용해서 처리합니다. ( 입력 x 반환 o )
        System.out.println("5. 무한 스트림 생성 - generate()");
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(5).forEach(System.out::println);

    }
}
