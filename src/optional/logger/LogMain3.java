package optional.logger;

public class LogMain3 {

    static void main() {
        Logger logger = new Logger();
        // true 로 설정했기 때문에 실행됨
        logger.setDebug(true);
        // 자바 언어의 연산자 우선순위상 메서드를 호출하기 전 괄호 안의 내용이 먼저 계산된다.
        logger.debug(() -> value100() + value200());

        /*
        실행순서
        1. 람다를 생성, 이 때 람다는 실행되지 않습니다.
        2. debug()를 호출하며 인자로 람다를 전달한다.
        3. supplier 에 람다가 전달된다.
        4. 디버그 모드이므로 if문이 실행
        5. supplier.get()을 실행하는 시점에 람다식이 실행 ( 계산, 평가 ) 됩니다.
        6. log 출력
         */


        System.out.println("=== 디버그 모드 끈 이후 실행 ===");
        logger.setDebug(false);
        // 람다를 넘김으로써, debug 메서드에서 해당 함수를 호출하지 않습니다.
        logger.debug(() -> value100() + value200());

        /*
        실행순서
        1. 람다를 생성, 이 때 람다는 실행되지 않습니다.
        2. debug()를 호출하며 인자로 람다를 전달한다.
        3. supplier 에 람다가 전달된다.
        4. 디버그 모드가 아니므로, 내부 코드가 수행되지 않으며 람다도 실행되지 않습니다.
         */
    }

    static int value100() {
        System.out.println("value100 호출");
        return 100;
    }

    static int value200() {
        System.out.println("value200 호출");
        return 200;
    }
}
