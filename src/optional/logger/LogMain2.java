package optional.logger;

public class LogMain2 {

    static void main() {
        Logger logger = new Logger();
        // true 로 설정했기 때문에 실행됨
        logger.setDebug(true);
        // 자바 언어의 연산자 우선순위상 메서드를 호출하기 전 괄호 안의 내용이 먼저 계산된다.
        logger.debug(value100() + value200());

        System.out.println("=== 디버그 모드 끈 이후 실행 ===");
        // false 로 설정했기 때문에 실행되지 않음
        logger.setDebug(false);
        // 해당 연산은 어디에도 사용되지 않지만 계산이 실행되고 버려진다.
        logger.debug(value100() + value200());

        System.out.println("=== 디버그 모드 체크 ===");

        if (logger.isDebug()) {
            // 필요없는 연산을 실행하지 않지만
            // 해당 코드를 작성하기 위해 if 문을 사용하는 등 코드 라인이 늘어납니다.
            logger.debug(value100() + value200());
        }

        // 연산을 정의하는 시점과 해당 연산을 실행하는 시점을 분리해서
        // 연산의 실행을 최대한 지연해서 평가하도록 설계해야 합니다.


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
