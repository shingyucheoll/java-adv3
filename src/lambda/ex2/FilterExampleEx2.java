package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExampleEx2 {

    // 고차 함수 !!  ( 함수를 인자로 받아서 조건에 맞는 요소만 뽑아내는 filter )
    // List 와 함수형 인터페이스를 인자로 받고
    // List 내부에 있는 값 중 Boolean 상태에 따라 필요 요소만 뽑아내어 다시 반환합니다.
    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            // 해당 값이 true 인 경우에만 result.add
            if (predicate.test(integer)) {
                result.add(integer);
            }
        }/**/
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
