package default_method.ex1;

import java.util.List;

public class NotifierMainV1 {

    static void main() {

        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());

        for (Notifier notifier : notifiers) {
            notifier.notify("서비스 가입을 환영합니다.");
        }

        notifiers.forEach(
            n -> n.notify("서비스 가입을 환영합니다!")
        );
    }
}
