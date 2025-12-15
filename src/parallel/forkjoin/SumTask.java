package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import parallel.HeavyJob;

public class SumTask extends RecursiveTask<Integer> {

	// private static final int THRESHOLD = 4; // 임계값
	private static final int THRESHOLD = 2; // 임계값 변경

	private final List<Integer> list;

	public SumTask(List<Integer> list) {
		this.list = list;
	}

	@Override
	protected Integer compute() {

		// 작업 범위가 임계값보다 작을 경우 직접 계산
		if (list.size() <= THRESHOLD) {

			log("[처리 시작] " + list);

			int sum = list.stream()
				.mapToInt(HeavyJob::heavyTask)
				.sum();

			log("[처리 완료] " + list + " -> sum: " + sum);
			return sum;
		} else {
			// 작업 범위가 크면 반으로 나누어 병렬 처리
			int mid = list.size() / 2;
			List<Integer> leftList = list.subList(0, mid); // 0 ~ mid 사이즈전까지
			List<Integer> rightList = list.subList(mid, list.size());  // mid 사이즈부터 끝까지7
			log("[분할] " + list + " -> leftList: " + leftList + ", rightList: " + rightList);

			SumTask leftTask = new SumTask(leftList);
			SumTask rightTask = new SumTask(rightList);

			// 왼쪽 작업은 다른 스레드에서 처리
			leftTask.fork();
			// 오른쪽 작업은 현재 스레드에서 직접 처리 (compute() 로 실행하여 else 문에 도달 후 다시 compute()를 현재 스레드에서 호출한다 -> (재귀호출))
			// 작업 갯수가 8개인 상태에서 / 2 로 생성된 Task 로 compute()를 호출하게 되면 if문 조건이 성립하여 직접 작업이 실행된다.
			Integer rightResult = rightTask.compute();

			// 왼쪽 작업 결과를 기다립니다.
			Integer leftResult = leftTask.join();
			int joinSum = leftResult + rightResult;
			log("LEFT[ + " + leftResult + "] + RIGHT [ " + rightResult + "] -> joinSum = " + joinSum);
			return joinSum;
		}
	}
}
