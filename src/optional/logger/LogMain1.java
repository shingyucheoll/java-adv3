package optional.logger;

public class LogMain1 {

    static void main() {
        Logger logger = new Logger();
        // true 로 설정했기 때문에 실행됨
        logger.setDebug(true);
        logger.debug(10 + 20);

        System.out.println();
        // false 로 설정했기 때문에 실행되지 않음
        logger.setDebug(false);
        // 해당 연산은 어디에도 사용되지 않지만 계산이 실행되고 버려진다.
        logger.debug(10 + 20);

        // 자바 언어의 연산자 우선순위상
        // 메서드를 호출하기 전 괄호 안의 내용이 먼저 계산된다.
        logger.debug(10 + 20); // 10 + 20 이 즉시 평가된다.
        logger.debug(30);      // 10 + 20 연산의 결과는 30이 된다.
        // debug(30)              // 메서드를 호출 이때 계산된 30의 값이 인자로 전달




    }
}
