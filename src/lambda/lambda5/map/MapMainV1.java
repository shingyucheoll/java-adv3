package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");
        System.out.println("strings = " + strings);

        // 문자열을 숫자로 변환
        List<Integer> numbers = mapStringToInteger(strings);
        System.out.println("numbers = " + numbers);

        // 문자열을 길이로 반환
        List<Integer> integers = mapStringToLength(strings);
        System.out.println("integers = " + integers);
    }

    private static List<Integer> mapStringToInteger(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            Integer value = Integer.valueOf(string);
            numbers.add(value);
        }
        return numbers;
    }

    private static List<Integer> mapStringToLength(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            Integer value = string.length();
            numbers.add(value);
        }
        return numbers;
    }
}
