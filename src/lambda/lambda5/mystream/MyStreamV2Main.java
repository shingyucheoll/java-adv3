package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV2Main {

    /*
    짝수만 남기고
    값의 2배를 반환하는 로직 작성
     */
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = MyStreamV2.of(numbers)
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .toList();

        System.out.println("result = " + result);
    }
}