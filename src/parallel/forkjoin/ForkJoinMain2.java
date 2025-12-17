package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinMain2 {

    static void main() {

        // 현재 사용 가능한 Processor 개수
        int processorCount = Runtime.getRuntime().availableProcessors();
        // parallelism -> 가용 Processor - 1 만큼 생성됨
        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        System.out.println("processorCount = " + processorCount);
        System.out.println("commonPool = " + commonPool);

        List<Integer> data = IntStream.rangeClosed(1, 8)
            .boxed()
            .toList();

        log("[생성] " + data);

        // ForkJoinPool pool = new ForkJoinPool(10);  -> ForkJoinPool 의 CommonPool 을 사용하기 때문에 제거


        SumTask task = new SumTask(data);

        // 작업에 즉시 invoke() 호출이 가능해지며, 이 때 공용 풀이 사용됩니다.
        // Main Thread 가 task 를 실행하게 됩니다.
        // 이 때 기존에는 생성된 pool을 갖고 작업을 진행하여 worker1이 해당 작업을 진행하였는데,
        // 이렇게 공용 Pool을 사용하게 될 경우
        // 아래와 같이 main 스레드가 작업의 compute()를 호출하여 직접 작업에 투입됩니다. -> invoke는 동기 메서드로 작업을 기다려야 하기 때문에
        // [     main] [생성] [1, 2, 3, 4, 5, 6, 7, 8]
        // [     main] [분할] [1, 2, 3, 4, 5, 6, 7, 8] -> leftList: [1, 2, 3, 4], rightList: [5, 6, 7, 8]
        // [     main] [분할] [5, 6, 7, 8] -> leftList: [5, 6], rightList: [7, 8]
        // [ForkJoinPool.commonPool-worker-1] [분할] [1, 2, 3, 4] -> leftList: [1, 2], rightList: [3, 4]
        // [     main] [처리 시작] [7, 8]
        Integer result = task.invoke();

        log("[결과] " + result);

    }
}
