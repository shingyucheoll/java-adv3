package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV2 {

    private final List<Integer> internalList;

    // 직접 생성 하지 못하도록 private 으로 차단
    private MyStreamV2(List<Integer> internalList) {
        this.internalList = internalList;
    }

    // static factory 생성 - 생성하려면 MyStreamV2.of 를 사용한다.
    public static MyStreamV2 of(List<Integer> internalList) {
        return new MyStreamV2(internalList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        // 갖고있는 값을 필터링 된 값으로 반환합니다.
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        // 갖고있는 값 중 매핑 된 값을 반환합니다.
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}

