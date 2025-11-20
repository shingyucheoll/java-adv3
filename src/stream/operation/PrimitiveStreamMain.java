package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {

    static void main() {
        // 기본형 특화 스트림 생성( IntStream, LongStream, DoubleStream )
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream range1 = IntStream.range(1, 6);
        IntStream range2 = IntStream.rangeClosed(1, 5);

        range1.forEach(i -> System.out.print(i + " "));
        System.out.println();
        range2.forEach(i -> System.out.print(i + " "));

        // 1. 통계 관련 메서드 ( sum, average, max, min, count)
        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum = " + sum);

        // average() : 평균값 계산
        double avg = IntStream.range(1, 6).average().getAsDouble();
        System.out.println("avg = " + avg);

        // summaryStatistics() : 모든 통계 정보
        IntSummaryStatistics statistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());
        System.out.println("statistics.getCount() = " + statistics.getCount());

        // 2. 타입 변환 메서드
        // IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 6).asLongStream();

        // IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 6).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 6).boxed();

        // 3. 기본형 특화 매핑
        // int -> long 변환 매핑
        LongStream mappedLong = IntStream.rangeClosed(1, 5).mapToLong(i -> i * 10L);

        // int -> double
        DoubleStream mappedDouble = IntStream.rangeClosed(1, 5).mapToDouble(i -> i * 1.5);

        // int -> 객체 변환 매핑
        Stream<String> mappedObj = IntStream.range(1, 5).mapToObj(i -> "Number : " + i);

        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(i -> i);

        // 5. 객체 스트림 -> 기본형 특화 스트림으로 매핑 활용
        int sum1 = Stream.of(1, 2, 3, 4, 5).mapToInt(i -> i).sum();



    }
}
