package optional;

import java.util.Optional;

public class OptionalCreationMain {

    static void main() {
        // 1. of() : 확실하게 값이 null 이 아닌 경우에만 사용 - null 인 경우 NPE 발생
        String nonNullValue = "Hello Optional";
        Optional<String> optional1 = Optional.of(nonNullValue);
        System.out.println("optional1 = " + optional1);

        // 2. ofNullable() : 값이 null 일 수 있을 때 사용 - null 인 경우 Optional.empty 반환
        Optional<String> optional2 = Optional.ofNullable("Hello");
        Optional<String> optional3 = Optional.ofNullable(null);
        System.out.println("optional2 = " + optional2);
        System.out.println("optional3 = " + optional3);

        // 3. empty() : 비어있는 Optional을 명시적으로 생성합니다.
        Optional<String> optional4 = Optional.empty();
        System.out.println("optional4 = " + optional4);



    }
}
