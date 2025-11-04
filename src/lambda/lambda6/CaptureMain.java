package lambda.lambda6;

public class CaptureMain {

    static void main() {
        final int final1 = 20;
        int final2 = 30;
        int changedVar = 10;

        // 1. 익명 클래스에서 캡처
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 - final1 : " + final1);
                System.out.println("익명 클래스 - final2 : " + final2);
                // 컴파일 오류
                // System.out.println("익명 클래스 - changedVar : " + changedVar);
            }
        };

        Runnable lambda = () -> {
            System.out.println("람다 - final1 : " + final1);
            System.out.println("람다 - final2 : " + final2);
            // 컴파일 오류
            // System.out.println("람다- changedVar : " + changedVar);
        };

        changedVar ++;
        anonymous.run();
        lambda.run();


    }


}
