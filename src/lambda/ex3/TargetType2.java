package lambda.ex3;

import java.util.function.Function;

// 자바가 기본적으로 제공하는 Function 사용
public class TargetType2 {

    public static void main(String[] args) {
        Function<String, String> upperCase = s -> s.toUpperCase();
        String result = upperCase. apply("Hello");
        System.out.println("result = " + result);

        Function<Integer, Integer> square = n -> n * n;
        Integer apply = square.apply(3);
        System.out.println("apply = " + apply);

    }


}
