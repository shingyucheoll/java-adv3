package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum : " + add.apply(5, 5));

        // String 과 Integer 2개
        BiConsumer<String, Integer> repeat = (c, n) -> {

            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        };
        repeat.accept("*", 10);


        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("Greater : " + isGreater.test(10, 5));

        // Supplier 는 매개변수가 없으므로 BiSupplier 는 없습니다.



    }
}
