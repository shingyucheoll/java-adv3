package lambda.ex3;

import java.util.List;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
    // BinaryOperator 사용 시 apply 로 변경!
    public static int reduce(List<Integer> list, int initial, IntBinaryOperator reducer) {
        int result = initial;
        for (int val : list) {
            result = reducer.applyAsInt(result, val);  // 0, 1

        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("numbers = " + numbers);

        // 합 구하기
        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // 곱 구하기
        int product = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("product = " + product);

    }
}
