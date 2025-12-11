package default_method.ex2;

public class SMSNotifier implements Notifier {

    @Override
    public void notify(String message) {
        System.out.println("[SMS] : " + message);
    }
}
