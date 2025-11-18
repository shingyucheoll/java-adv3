package stream.operation;

import java.util.Optional;

public class OptionalSimpleMain {

    static void main() {
        Optional<Integer> optional1 = Optional.of(10);
        System.out.println("optional1 = " + optional1);

        // 값이 있는지 확인할 수 있는 안전한 메서드를 제공
        if (optional1.isPresent()) {
            Integer i = optional1.get();
            System.out.println("i = " + i);
        }

        Optional<Object> optional2 = Optional.ofNullable(null);
        // Optional.empty 출력
        System.out.println("optional2 = " + optional2);
        // null 이기 때문에 실행되지 않는 코드
        if (optional2.isPresent()) {
            Object o = optional2.get();
            System.out.println("o = " + o);
        }

        // 값이 없는 Optional 에서 get() 을 호출하게 되면 NoSuchElementException 이 발생합니다.
        Object o = optional2.get();
        System.out.println("o = " + o);
    }
}
