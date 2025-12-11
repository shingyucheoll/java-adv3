package default_method.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {

    static void main() {

        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());

        notifiers.forEach(
            n -> n.notify("서비스 가입을 환영합니다!")
        );

        // 스케줄 기능 추가
        LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);
        notifiers.forEach(
            n -> n.scheduleNotification("스케줄 메세지 발송", plus1Days)
        );

    }
}
