package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {

    static void main() {
        Long count1 = Stream.of(1, 2, 3)
            .collect(Collectors.counting());
        System.out.println("count1 = " + count1);

        long count2 = Stream.of(1, 2, 3)
            .count();
        System.out.println("count2 = " + count2);

        Double average1 = Stream.of(1, 2, 3)
            .collect(Collectors.averagingInt(i -> i));
        System.out.println("average1 = " + average1);

        // 기본형 특화 스트림으로 변환하여 사용
        double average2 = Stream.of(1, 2, 3)
            .mapToInt(i -> i)
            .average()
            .getAsDouble();
        System.out.println("average2 = " + average2);

        // 기본형 특화 스트림 사용
        double average3 = IntStream.of(1, 2, 3)
            .average()
            .getAsDouble();
        System.out.println("average3 = " + average3);

        // 통계를 지원하는 SummaryStatistics 객체로 반환 받습니다.
        IntSummaryStatistics statistics = Stream.of("Apple", "Banana", "Orange")
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("statistics = " + statistics);
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println();


    }
}
