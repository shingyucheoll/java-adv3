package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV3<T> {

    private final List<T> internalList;

    // 직접 생성 하지 못하도록 private 으로 차단
    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }

    // static factory 생성 - 생성하려면 MyStreamV2.of 를 사용한다.
    public static <T> MyStreamV3<T> of(List<T> internalList) {
        return new MyStreamV3<>(internalList);
    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        // 갖고있는 값을 필터링 된 값으로 반환합니다.
        return MyStreamV3.of(filtered);
    }

    public <R> MyStreamV3<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T element : internalList) {
            mapped.add(mapper.apply(element));
        }
        // 갖고있는 값 중 매핑 된 값을 반환합니다.
        return MyStreamV3.of(mapped);
    }

    public List<T> toList() {
        return internalList;
    }

    // 추가
    public void forEach(Consumer<T> consumer) {
        // consumer 는 accept ! -> 소비한다.
        for (T element : internalList) {
            consumer.accept(element);
        }
    }
}

