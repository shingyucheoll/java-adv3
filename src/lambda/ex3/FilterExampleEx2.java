package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExampleEx2 {

    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            // 해당 값이 true 인 경우에만 result.add
            if (predicate.test(integer)) {
                result.add(integer);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, -2, -3, -4);
        System.out.println("numbers = " + numbers);

        // 테스트 결과가 true 일 때만 결과 리스트에 추가합니다.
        List<Integer> negatives = filter(numbers, (number) -> number < 0);
        System.out.println("negatives = " + negatives);

        List<Integer> even = filter(numbers, (number) -> number % 2 == 0);
        System.out.println("even = " + even);
    }

}
