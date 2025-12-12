package parallel;

import static util.MyLogger.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMain3 {

    static void main() throws InterruptedException, ExecutionException {

        // Thread Pool init
        ExecutorService es = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        // 1. Fork - 작업 분할
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);


        // 2. 분할 작업 처리
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        // 3. join - 처리 결과 병합
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        log("main thread 대기 완료 - (모든 thread 작업 완료)");
        int sum = result1 + result2;

        long endTime = System.currentTimeMillis();
        log("time = " + (endTime - startTime) + "ms, sum : " + sum);
    }

    // 반환값이 있는 경우에는 Callable을 구현해야 합니다.
    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        // run() 이 아닌 call() 구현 - 응답이 있는 Thread
        @Override
        public Integer call() {
            log("작업 시작");
            int sum = 0;

            for (int i = startValue; i <= endValue; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            log("작업 완료 result = " + sum);
            return sum;
        }
    }
}
