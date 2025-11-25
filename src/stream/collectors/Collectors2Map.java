package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {

    static void main() {
        // {key = value} 형태의 Map 구조로 변경
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
            .collect(Collectors.toMap(
                name -> name,           // keyMapper
                name -> name.length())  // valueMapper
            );
        System.out.println("map1 = " + map1);

        // 중복된 Key 가 있을 경우 런타임 에러 발생 !
        // Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Tomato")
        //     .collect(Collectors.toMap(
        //         name -> name,           // keyMapper
        //         name -> name.length())  // valueMapper
        //     );
        // System.out.println("map2 = " + map2);

        // 중복된 Key 가 있을 경우 처리하는 방법
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Tomato")
            .collect(Collectors.toMap(
                    name -> name,            // keyMapper
                    name -> name.length(),   // valueMapper
                    (oldVal, newVal) -> oldVal + newVal // 중복될 경우 기존 값 + 새 값  ( BinaryOperator )
                )
            );
        System.out.println("map3 = " + map3);

        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Tomato")
            .collect(Collectors.toMap(
                name -> name,            // keyMapper
                name -> name.length(),   // valueMapper
                (oldVal, newVal) -> oldVal + newVal,    // 중복될 경우 기존 값 + 새 값  ( BinaryOperator )
                LinkedHashMap::new                                    // mapFactory
            ));
        System.out.println("map4 = " + map4.getClass());



    }
}
