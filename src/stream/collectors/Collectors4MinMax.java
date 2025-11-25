package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {

    static void main() {
        // 다운 스트림 컬렉터에서 유용하게 사용 가능합니다.
        Integer max1 = Stream.of(1, 2, 3, 4, 5)
            .collect(Collectors.maxBy(
                (i1, i2) -> i1.compareTo(i2)
            )).get();
        System.out.println("max1 = " + max1);

        Integer max2 = Stream.of(1, 2, 3, 4, 5)
            .max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("max2 = " + max2);

        Integer max3 = Stream.of(1, 2, 3, 4, 5)
            .max(Integer::compareTo).get();
        System.out.println("max3 = " + max3);

        // 기본형 특화 스트림 사용
        int max4 = IntStream.of(1, 2, 3, 4, 5).max().getAsInt();
        System.out.println("max4 = " + max4);

    }
}
