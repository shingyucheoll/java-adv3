package optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {

    static void main() {

        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        System.out.println("단순 계산");
        Integer i1 = optValue.orElse(10 + 20);
        Integer i2 = optEmpty.orElse(10 + 20);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);

        // orElse() 값이 있으면 그 값, 없으면 지정된 기본값을 사용합니다.
        System.out.println("===== orElse() =====");

        // 값이 있는데도 불구하고 orElse() 내부의 메서드를 실행하게 됩니다. - 즉시 평가
        Integer value1 = optValue.orElse(createData());
        System.out.println("value1 = " + value1);

        Integer empty1 = optEmpty.orElse(createData());
        System.out.println("empty1 = " + empty1);

        System.out.println("===== orElseGet() =====");
        // orElseGet() 을 사용하게 된 경우 값이 있는 경우 내부 메서드를 실행하지 않고 있는 값 그대로 반환합니다.
        // public T orElseGet(Supplier<? extends T> supplier) {
        //     return value != null ? value : supplier.get();
        // }
        // 위와 같이 supplier 를 파라미터로 전달받으며 orElseGet을 사용한 값이 null 이 아닌 경우 supplier.get() 메서드를 실행합니다.
        Integer value2 = optValue.orElseGet(OrElseGetMain::createData);
        System.out.println("value2 = " + value2);

        Integer empty2 = optEmpty.orElseGet(OrElseGetMain::createData);
        System.out.println("empty2 = " + empty2);

    }

    static int createData() {
        System.out.println("데이터 생성");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        int createValue = new Random().nextInt(100);
        System.out.println("데이터 생성이 완료되었습니다. 값 : " + createValue);
        return createValue;
    }
}
