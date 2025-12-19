package parallel;

import static util.MyLogger.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ParallelMain7 {
	static void main() throws InterruptedException {
		// 요청 풀 추가
		ExecutorService requestPool = Executors.newFixedThreadPool(100);

		// logic 처리 전용 스레드 풀 추가
		ExecutorService logicPool = Executors.newFixedThreadPool(400);

		int nThreads = 3; // 1, 2, 3, 10, 20 으로 변경하면서 테스트
		for (int i = 1; i <= nThreads; i++) {
			String requestName = "request" + i;
			requestPool.submit(() -> logic(requestName, logicPool));
			Thread.sleep(100); // 스레드 순서를 확인하기 위해 약간 대기
		}

		requestPool.close();
		logicPool.close();
	}

	private static void logic(String requestName, ExecutorService es) {
		log("[" + requestName + "] START");
		long startTime = System.currentTimeMillis();

		List<Future<Integer>> futures = IntStream.range(1, 4)
			.mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
			.toList();

		// 개별 Future 변수 대신 IntStream과 mapToObj를 사용하여 작업 제출을 간결화
		int sum = futures.stream()
			.mapToInt(f -> {
				// Lambda 는 기본적으로 Check Exception을 밖으로 던질 수 없습니다.
				// 잡아서 처리하거나
				// Runtime으로 변경하여 반환합니다.
				// try {
				//     return f.get();
				// } catch (InterruptedException e) {
				//     throw new RuntimeException(e);
				// } catch (ExecutionException e) {
				//     throw new RuntimeException(e);
				// }
				try {
					return f.get();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			})
			.sum();


        long endTime = System.currentTimeMillis();
		log("[" + requestName + "] END time: " + (endTime - startTime) + "ms, sum = " + sum);

	}
}
