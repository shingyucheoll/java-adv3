package stream.basic;

import java.util.List;

import lambda.lambda5.mystream.MyStreamV3;

public class LazyEvalMain1 {

    static void main() {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    // 우리가 만든 Stream 사용
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        List<Integer> result = MyStreamV3.of(data)
            .filter(i -> {
                boolean isEven = i % 2 == 0;
                System.out.println("filter() 실행 = " + i + "(" + isEven + ")");
                return isEven;
            })
            .map(i -> {
                int mapped = i * 10;
                System.out.println("map() 실행 " + i + " -> " + mapped);
                return mapped;
            })
            .toList();

        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");

        // filter() 실행 = 1(false)
        // filter() 실행 = 2(true)
        // filter() 실행 = 3(false)
        // filter() 실행 = 4(true)
        // filter() 실행 = 5(false)
        // filter() 실행 = 6(true)        -> 전부 모아서 처리
        // map() 실행 2 -> 20
        // map() 실행 4 -> 40
        // map() 실행 6 -> 60
        // result = [20, 40, 60]

    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        List<Integer> result = data.stream()
            .filter(i -> {
                boolean isEven = i % 2 == 0;
                System.out.println("filter() 실행 = " + i + "(" + isEven + ")");
                return isEven;
            })
            .map(i -> {
                int mapped = i * 10;
                System.out.println("map() 실행 " + i + " -> " + mapped);
                return mapped;
            })
            .toList();

        System.out.println("result = " + result);
        System.out.println("== Stream API 종료 ==");

        // filter() 실행 = 1(false)
        // filter() 실행 = 2(true)
        // map() 실행 2 -> 20             -> 바로 다음단게 !
        // filter() 실행 = 3(false)
        // filter() 실행 = 4(true)
        // map() 실행 4 -> 40             -> 바로 다음단게 !
        // filter() 실행 = 5(false)
        // filter() 실행 = 6(true)
        // map() 실행 6 -> 60
        // result = [20, 40, 60]


    }
}
