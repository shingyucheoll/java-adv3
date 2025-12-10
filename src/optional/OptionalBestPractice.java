package optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalBestPractice {

    // 1. 공식문서에서 Optional은 메서드의 반환값으로 사용하기를 권장하며
    // 매개변수로 사용하지 말라고 '명시'되어 있다.

    // o
    public Optional methodName(String s) {

        return Optional.empty();
    }

    // x method 를 분리하거나, 방어적 코드를 작성하는게 더 좋다
    public void methodName(Optional<?> element) {

    }

    // 2. Collection이나 배열 탕비을 Optional로 감싸지 않는다.
    // List<T>, Set<T>, Map<K, V> 등 Collection 을 구현한 객체는 자체적으로 empty를 표현할 수 있기 때문에
    // Collections.emptyList() 가 이중 표현되어 혼란을 야기한다.

    // x
    public Optional<List<String>> methodName() {
        return Optional.empty();
    }

    // 빈 리스트를 반환하여 처리한다.
    // -> List 가 반환값인데 null을 반환하는 코드는 안티패턴
    // -> return Collections.emptyList(); 를 반환한다
    public List<String> method() {
        return Collections.emptyList();
    }

    // 3. isPresent() 와 get() 조합을 직접 사용하지 않습니다.
    // Optional 의 get() 메서드는 가급적 사용하지 않으며
    // orElse, orElseGet, orElseThrow, ifPresentOrElse와 같은 메서드를 활용합니다.
    public void usePattern(Optional<String> optStr) {
        // 지양패턴
        if (optStr.isPresent()) {
            System.out.println(optStr.get());
        } else {
            System.out.println("Nothing");
        }

        // 지향패턴
        optStr.orElse("Nothing");
        optStr.ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Nothing")
        );
    }

    // 4. orElseGet() vs orElse() 확실히 이해하고 사용하기!
    //     orElse(T other): 즉시평가
    //     () 내부의 other 를 즉시 생성하거나 계산합니다.
    //
    // orElseGet(Supplier<? extends T>): 지연평가
    //     () 내부의 Supplier 를 필요할 때 호출합니다.
    // -> Optional 값이 존재할 가능성이 높다면 orElseGet() 사용하기

}
