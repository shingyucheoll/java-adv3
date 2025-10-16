package lambda.ex2;

import java.util.List;

public class ReduceExample {
    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (int val : list) {
            result = reducer.reduce(result, val);  // 0, 1

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
