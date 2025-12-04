package optional;

import java.util.Optional;

// Retrieval - 검색
public class OptionalRetrievalMain {

    static void main() {

        // 예제 : 문자열 "Hello" 가 있는 Optional 과 비어있는 Optional 을 준비
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // isPresent() : 값이 있으면 true, 없으면 false
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        // isEmpty() : 비어있는 값인 경우 true
        System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

        // get() : 내부 값을 꺼내며, 값이 없는 경우 에러 ( NoSuchElementException )
        String getValue = optValue.get();
        System.out.println("getValue = " + getValue);
        // String getEmpty = optEmpty.get();    // java.util.NoSuchElementException: No value present 예외 발생 - 주석 처리

        // orElse(T other) : 값이 있으면 값을, other 값을 반환
        String value1 = optValue.orElse("기본값");
        System.out.println("value1 = " + value1);       // Hello
        String empty1 = optEmpty.orElse("기본값");
        System.out.println("empty1 = " + empty1);       // 기본값

        // orElseGet() : 값이 없는 경우 Supplier 가 실행되어 기본값을 생성합니다.
        String value2 = optValue.orElseGet(
            () -> {
                System.out.println("Supplier 람다 호출 - 입력값 x 반환값 o");
                return "New Value";
            }
        );
        // 값이 있기 떄문에 Hello 출력
        System.out.println("value2 = " + value2);

        // 해당 케이스만 람다가 실행되어 로그가 출력됩니다. "Supplier 람다 호출 - 입력값 x 반환값 o"
        String empty2 = optEmpty.orElseGet(
            () -> {
                System.out.println("Supplier 람다 호출 - 입력값 x 반환값 o");
                return "New Value";
            }
        );
        // 기존 값이 없기 때문에 Lambda 가 실행되어 로그 출력 + 값을 New Value 로 설정됨
        System.out.println("empty2 = " + empty2);

        // orElseThrow(Throw t) : 값이 있으면 반환하고 empty 인 경우 Throw
        String value3 = optValue.orElseThrow(
            () -> new RuntimeException("값이 없습니다.")
        );
        System.out.println("value3 = " + value3);

        // 지정된 예외 발생
        // String empty3 = optEmpty.orElseThrow(
        //     () -> new RuntimeException("값이 없습니다.")
        // );

        try {
            String empty3 = optEmpty.orElseThrow(
                () -> new RuntimeException("값이 없습니다.")
            );
            // 실행되지 않고 catch 의 메세지 발생
            System.out.println("empty3 = " + empty3);
        } catch (Exception e){
            System.out.println("예외 발생 " + e);
        }

        // or() : 값이 있으면 값을 가진 Optional 그대로 반환, 값이 없으면 새로 생성된 Optional 객체를 반환
        Optional<String> result1 = optValue.or(
            () -> Optional.of("Fallback")
        );
        // Optional[Hell] 기존 Optional 반환
        System.out.println("result1 = " + result1);


        Optional<String> result2 = optEmpty.or(
            () -> Optional.of("Fallback")
        );
        // Optional[Fallback] 변경된 값으로 Optional 반환
        System.out.println("result2 = " + result2);

    }
}
