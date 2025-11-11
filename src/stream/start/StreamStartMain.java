package stream.start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {

    private static final String REPEAT = ("=").repeat(15);

    static void main() {
        List<String> names = List.of(
            "Apple",
            "Banana",
            "Berry",
            "Tomato"
        );

        Stream<String> stream = names.stream();

        List<String> result = stream.filter(name -> name.startsWith("B"))
            .map(s -> s.toUpperCase())
            .toList();

        System.out.println(REPEAT + " for 외부 반복 " + REPEAT);
        for (String s : result) {
            System.out.println(s);
        }


        System.out.println(REPEAT + " forEach - 내부 반복 " + REPEAT);
        names.stream()
            .filter(name -> name.startsWith("B"))
            .map(s -> s.toUpperCase())
            .forEach(s -> System.out.println(s));


        System.out.println(REPEAT + " 메서드 참조 " + REPEAT);
        names.stream()
            .filter(name -> name.startsWith("B"))
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
