package lambda.lambda4;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0;
            };
        };
        System.out.println("isEvenPredicate.test(10) = " + isEvenPredicate.test(10));

        Predicate<Integer> predicate2 = i -> i % 2 == 0;
        System.out.println("predicate2.test(10) = " + predicate2.test(10));

        /*
        Predicate 가 꼭 필요한가..? 아래와 같이 Function 으로 처리할 수 있는데?
        함수형 인터페이스의 의도를 명시적으로 드러내기 위한 정의된 함수형 인터페이스로
        Function<T, Boolean> 으로 사용할 수 있지만, 의도가 더 분명해집니다.

        예시로 조건을 판단하는 함수로
        Predicate<T> 라는 패턴을 사용함으로써 의미 전달이 명확해집니다.
        또한, Generic 에 Boolean 을 적지 않아도 된다. ( 함수 내부 메서드에 반환값이 정해져 있기 때문에 )
        */
        Function<Integer, Boolean> function = i -> i % 2 == 0;
        System.out.println("function.apply(10) = " + function.apply(10));



    }
}
