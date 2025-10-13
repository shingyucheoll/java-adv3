package lambda.lambda2;

import lambda.MyFunction;

// 1. 람다를 변수에 대입하기
public class LambdaPassMain1 {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("add.apply(1, 2) = " + add.apply(1, 2));
        System.out.println("sub.apply(1, 2) = " + sub.apply(1, 2));

        // 함수형 인터페이스이기 때문에
        // 형식에 맞는 람다를 대입하여 사용할 수 있다! ( 메서드 시그니처가 일치하기 때문에 )
        MyFunction calculate = add;
        System.out.println("cal(add).apply(1, 2) = " + calculate.apply(1, 2));

        calculate = sub;
        System.out.println("calculate(add).apply(1, 2) = " + calculate.apply(1, 2));

    }
}
