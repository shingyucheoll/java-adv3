package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {

    public static void main(String[] args) {

        Function<Integer, Integer> square1 = x -> x * x;

        /*
        UnaryOperator
        Integer 를 입력받을 경우 Integer를 반환합니다.
         */
        UnaryOperator<Integer> square2 = x -> x * x;
        System.out.println("square1 = " + square1.apply(5));
        System.out.println("square2 = " + square2.apply(5));

        // BinaryOperator <T, U, R>
        BiFunction<Integer, Integer, Integer> square3 = (x, y) -> x * y;

        // Integer 반환타입과 같은 타입의 객체 두 개를 사용하여 반환 받습니다.
        BinaryOperator<Integer> square4 = (x, y) -> x * y;

        System.out.println("square3 = " + square3.apply(5, 5));
        System.out.println("square4 = " + square4.apply(5, 5));
        




    }
}
