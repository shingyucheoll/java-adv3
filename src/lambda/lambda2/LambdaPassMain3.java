package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain3 {

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println("add.apply(1, 2) = " + add.apply(1, 2));

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply(1, 2) = " + sub.apply(1, 2));

        MyFunction calculate = getOperation("calculate");
        System.out.println("xxx.apply(1, 2) = " + calculate.apply(1, 2));

        /**
         * 분석
         * 1. 메서드를 호출한다.
         * 2. getOperation() 메서드 에서 반환 타입이 MyFunction ( 함수형 인터페이스 ) 이다.
         * 3. Switch 문에 맞는 람다 인스턴스를 생성과 동시에 참조값을 반환합니다.
         * 4. main 메서드로 람다 인스턴스의 참조값이 반환되어 반환된 함수를 사용하게 됩니다.
         */

    }

    // 람다를 반환하는 메서드
    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a, b) -> 0;
        }
    }

}




