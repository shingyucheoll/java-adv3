package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

public class Ex1_Number {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> direct = direct(numbers);
        System.out.println("direct = " + direct);

        List<Integer> lambda = lambda(numbers);
        System.out.println("lambda = " + lambda);

    }

    static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number * 2);
            }
        }
        return result;
    }

    static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filter = GenericFilter.filter(numbers, n -> n % 2 == 0);
        return GenericMapper.map(filter, n -> n * 2);
    }
}
