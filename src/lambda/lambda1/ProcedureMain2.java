package lambda.lambda1;

import lambda.Procedure;

public class ProcedureMain2 {

    public static void main(String[] args) {
        // () 메서드의 매개변수, {} 부분이 코드 조각이 들어가는 본문
        Procedure procedure = () -> {
            System.out.println("Hello lambda");
        };

        procedure.run();
    }
}
