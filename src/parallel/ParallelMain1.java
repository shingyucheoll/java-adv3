package parallel;

import static util.MyLogger.*;

import java.util.stream.IntStream;

public class ParallelMain1 {

    static void main() {

        long startTime = System.currentTimeMillis();

        // 단일 스트림 사용하여 순차적 실행
        int sum = IntStream.rangeClosed(1, 8)   // 8번 실행 후 종료
            .map(HeavyJob::heavyTask)           // 총 8번 호출
            .reduce(0, Integer::sum);           // 모든 결과값을 sum

        long endTime = System.currentTimeMillis();

        log("time = " + (endTime - startTime) + "ms, sum : " + sum);
    }
}
