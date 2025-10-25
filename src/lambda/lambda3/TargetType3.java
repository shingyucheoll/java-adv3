package lambda.lambda3;

import java.util.function.Function;

// 자바가 기본으로 제공하는 Function 대입
public class TargetType3 {

    public static void main(String[] args) {

        Function<Integer, String> functionA = i -> "value = " + i;
        System.out.println(functionA.apply(10));

        // TargetType1 과 다르게 함수형 인터페이스의 타입이 Function 으로 동일하기 때문에 대입이 가능해집니다.
        Function<Integer, String> functionB = functionA;
        System.out.println(functionB.apply(10));

    }
}
