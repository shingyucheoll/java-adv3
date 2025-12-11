package default_method.ex2;

import java.time.LocalDateTime;

public interface Notifier {
    // 알림 전송 기능
    void notify(String message);

    // 신규 기능 추가
    // default 를 추가하게 된 경우 해당 인터페이스의 구현체들은 수정 없이 기존 동작을 그대로 유지할 수 있게 됩니다.
    // 현재 ex2 패키지 내부에서 EmailNotifier 만 해당 메서드를 구현하고 있으며
    // 다른 Notifier 를 구현한 클래스들은 해당 메서드를 구현하지 않고 있어도 문제없이 동작 가능합니다.
    default void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[기본 스케줄링] message : " + message + ", time : " + scheduleTime);
    }

}
