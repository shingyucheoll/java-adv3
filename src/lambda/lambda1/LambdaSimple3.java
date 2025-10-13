package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {

    public static void main(String[] args) {
        // 타입 생략 전
        MyFunction function1 = (int a, int b) -> a + b;
        System.out.println("function1 = " + function1.apply(10, 20));

        // MyFunction 을 통해 타입 추론이 가능하여 타입 생략이 가능합니다.
        MyFunction function2 = (a, b) -> a + b;
        int apply = function2.apply(10, 20);
        System.out.println("function2 = " + apply);





    }
}
