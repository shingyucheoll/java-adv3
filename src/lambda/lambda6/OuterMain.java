package lambda.lambda6;

public class OuterMain {

    private final String message = "와부 클래스";


    public void execute() {
        // 1. 익명 클래스 예시
        Runnable anonymous = new Runnable() {
            private String message = "익명 클래스";

            @Override
            public void run() {
                // 익명 클래스에서 this 는 익명 클래스의 인스턴스를 가르킵니다.
                System.out.println("[익명 클래스] this : " + this);
                System.out.println("[익명 클래스] this.class : " + this.getClass());
                System.out.println("[익명 클래스] this.message : " + this.message);
            }
        };

        // 람다 예시
        Runnable lambda = () -> {
            // 람다에서 this 는 람다가 선언된 클래스의 인스턴스를 가르킵니다. ( 외부 클래스 )
            System.out.println("[람다] this : " + this);
            System.out.println("[람다] this.class : " + this.getClass());
            System.out.println("[람다] this.message : " + this.message);
        };

        anonymous.run();
        System.out.println("-".repeat(50));
        lambda.run();

    }

    static void main() {
        OuterMain outer = new OuterMain();
        System.out.println("[외부 클래스]: " + outer);
        System.out.println("-".repeat(50));
        outer.execute();
    }


}
