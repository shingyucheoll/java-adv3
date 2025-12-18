package parallel;

import static util.MyLogger.*;

import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelMain4 {

    static void main() {

		int processorCount = Runtime.getRuntime().availableProcessors();
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		log("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());

		long startTime = System.currentTimeMillis();

        // 단일 스트림 사용하여 순차적 실행
        int sum = IntStream.rangeClosed(1, 8)   // 8번 실행 후 종료
			.parallel()							// ForkJoinPool의 commonPool 을 사용합니다!
            .map(HeavyJob::heavyTask)           // 총 8번 호출
            .reduce(0, Integer::sum);           // 모든 결과값을 sum

        long endTime = System.currentTimeMillis();

        log("time = " + (endTime - startTime) + "ms, sum : " + sum);
    }
}
