package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "nanana", "orange");

        // String -> String
        List<String> upperFruits = GenericMapper.map(fruits, s -> s.toUpperCase());
        System.out.println("upperFruits = " + upperFruits);

        // String -> Integer
        List<Integer> lengthFruits = GenericMapper.map(fruits, s -> s.length());
        System.out.println("lengthFruits = " + lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3, 10);
        List<String> starList = GenericMapper.map(integers, n -> "*".repeat(n));
        System.out.println("starList = " + starList);

        // repeat(n)  ->  JAVA 11 버전에 추가된 메서드로 같은 문자를 count 수 만큼 붙여셔 반환한다.
        System.out.println("\"hello\".repeat(2) = " + "hello".repeat(2));



    }
}
