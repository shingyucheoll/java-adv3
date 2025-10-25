package lambda.lambda3;

public class TargetType1 {

    public static void main(String[] args) {
        // 람다 직접 대입 : 문제 없음
        FunctionA functionA = i -> "value = " + i;
        System.out.println("functionA.apply(10) = " + functionA.apply(10));

        FunctionB functionB = i -> "value = " + i;
        System.out.println("functionB.apply(10) = " + functionB.apply(10));

        /**
         * FunctionA 와 FunctionB 의 타입은 다르기 때문에
         * String a = "1"
         * Integer b = 2
         * a = b 와 같이 JAVA 의 타입 체크에서 절대 불가능한 구조
         */
        // 이미 만들어진 FunctionA 인스턴스를 FunctionB 에 대입은 되지 않습니다.
        // FunctionB tragetB = functionA;  // 컴파일 에러

        // FunctionA functionA = i -> "value = " + i;
        // 위 코드에서 람다식 ( i -> "value = " + i ) 자체만으론 구체적인 타입이 정해져 있지 않은 상태

        // 대입되는 함수형 인터페이스 ( target Type ) 에 의해 타입이 결정되는것

        // 이렇게 타입이 결정되고 나면 다른 타입으로 대입하는 것이 불가능하다.
        // 따라서 아무리 함수형 인터페이스의 내부 시그니쳐 타입이 같더라도,
        // 대입이 불가능하다.

        // -> 이것은 마치 Integer 에 String 을 대입하는 것과 같다.


    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer i);
    }
}
