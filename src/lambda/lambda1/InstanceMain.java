package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {

            }
        };
        // 익명 클래스는 뒤에 $1 로 표현됩니다.
        System.out.println("class.class = " + procedure.getClass());
        // 인스턴스는 $1 뒤에 Instance 참조 ?   ??
        System.out.println("class.instance = " + procedure);

        Procedure procedure2 = () -> {
            System.out.println("hello! lambda");
        };

        // 익명 클래스는 뒤에 $1 로 표현됩니다.
        System.out.println("lambda.class = " + procedure2.getClass());
        // 인스턴스는 $1 뒤에 Instance 참조 ?   ??
        System.out.println("lambda.instance = " + procedure2);
    }
}
