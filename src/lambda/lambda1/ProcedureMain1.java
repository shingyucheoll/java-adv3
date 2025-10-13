package lambda.lambda1;

import lambda.Procedure;

public class ProcedureMain1 {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {

            // 매개변수가 없으며, void
            @Override
            public void run() {
                System.out.println("Hello lambda");
            }

        };

        procedure.run();
    }
}
