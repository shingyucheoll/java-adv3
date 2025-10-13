package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple1 {

    public static void main(String[] args) {

        // 기본
        MyFunction function1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println("function1 = " + function1.apply(10, 20));

        // 단일 표현식인 경우 중괄호와 리턴 생략이 가능합니다. ->  { return  ... ; }
        MyFunction function2 = (int a, int b) -> a + b;
        System.out.println("function2 = " + function1.apply(10, 20));

        // 단일 표현식이 아닌 경우 중괄호와 리턴 모두 필수 -> 중간에 다른 로직이 섞여 있는 경우
        MyFunction function3 = (int a, int b) -> {
            System.out.println("람다 실행");
            return a + b;
        };
        System.out.println("function3 = " + function1.apply(10, 20));


    }
}
