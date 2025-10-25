package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExample {

    public static List<String> map(List<String> list, UnaryOperator<String> func) {
        List<String> result = new ArrayList<>();
        for (String input : list) {
            result.add(func.apply(input));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "world", "java", "lambda");
        System.out.println("원본 리스트 : " + words);

        List<String> upperList = map(words, String::toUpperCase);
        System.out.println("upperList = " + upperList);

        List<String> decoratedList = map(words, s -> "***" + s + "***");
        System.out.println("decoratedList = " + decoratedList);
    }


}
