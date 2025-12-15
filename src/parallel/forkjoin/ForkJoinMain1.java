package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;


public class ForkJoinMain1 {

    static void main() {

        List<Integer> data = IntStream.rangeClosed(1, 8)
            .boxed()
            .toList();

        log("[생성] " + data);

        long startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(10);
        // 내부에 재귀 호출을 통한 분할 로직이 들어 있습니다.
        SumTask task = new SumTask(data);

        Integer result = pool.invoke(task);

        pool.close();
        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + result);
        log("pool: " + pool);
    }
}
