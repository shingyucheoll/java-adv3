package optional.logger;

import java.util.function.Supplier;

public class Logger {

    private boolean isDebug = false;

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    // DEBUG 로 설정한 경우만 출력 - 데이터를 받습니다.
    public void debug(Object message) {
        System.out.println("debug 호출");
        if(isDebug) {
            System.out.println("[DEBUG] " + message);
        }
    }

    // 추가
    // DEBUG로 설정한 경우만 출력하며 Supplier 람다를 받아서 실행합니다.
    public void debug(Supplier<?> supplier) {
        System.out.println("debug 호출");
        if (isDebug) {
            System.out.println("[DEBUG] " + supplier.get());
        }
    }
}
