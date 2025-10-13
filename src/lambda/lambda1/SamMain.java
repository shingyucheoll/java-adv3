package lambda.lambda1;

public class SamMain {

    public static void main(String[] args) {
        SamInterface samInterface = () ->
        {
            System.out.println("sam");
        };
        samInterface.run();

        /**
         * NotSamInterface is not a functional interface  -> 함수형 인터페이스가 아니여서 컴파일 오류!
         * multiple non-overriding abstract methods found in interface lambda.lambda1.NotSamInterface
         */
        // NotSamInterface notSamInterface = () -> {
        //     System.out.println("notSam");
        // };
        //
        // notSamInterface.run();
        // notSamInterface.go();




    }
}
