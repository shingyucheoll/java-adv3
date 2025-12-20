package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain {

    static void main() throws InterruptedException {

        CompletableFuture.runAsync(
            () -> log("Fork/Join")
        );
        // [ForkJoinPool.commonPool-worker-1] Fork/Join
        // 스레드 풀 지정하지 않을 때 공용풀을 사용하게 됨..!!
        // I/O 작업시 무조건 문제가 발생함

        ExecutorService es = Executors.newFixedThreadPool(100);

        CompletableFuture.runAsync(
            () -> log("Fork/Join"),
            es
        );

        // [ForkJoinPool.commonPool-worker-1] Fork/Join
        // [pool-1-thread-1] Fork/Join

        es.close();



        Thread.sleep(1000);

    }
}
