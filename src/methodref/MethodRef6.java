package methodref;

import java.util.function.BiFunction;

public class MethodRef6 {

    // 5개의 타입 매개변수를 받는 함수형 인터페이스 (입력 4개 + 반환값 1개)
    @FunctionalInterface
    interface QuadFunction<T, U, V, W, R> {
        R apply(T t, U u, V v, W w);
    }

    public static void main(String[] args) {
        // 임의 객체의 인스턴스 메서드 참조
        Person person = new Person("Kim");

        // 람다
        // Person과 Integer 를 매개변수로 사용하고 String 을 반환 받습니다.
        BiFunction<Person, Integer, String> func1 =
            (Person p, Integer number) -> p.introduceWithNumber(number);
        System.out.println("func1 = " + func1.apply(person, 1));

        // 메서드 참조 - 타입이 첫 번째 매개변수가 되고, 첫 번째 매개변수의 메서드를 호출
        // 나머지는 순서대로 매개변수에 전달
        // 첫 번째 타입 매개변수: 메서드를 호출할 인스턴스 (Person)
        // 두 번째부터 n-1번째 타입 매개변수: 메서드의 인자들 (Integer)
        // n번째 타입 매개변수: 반환값 (String)
        BiFunction<Person, Integer, String> func2 = Person::introduceWithNumber;
        System.out.println("func2 = " + func2.apply(person, 1));

        System.out.println("\n=== QuadFunction 테스트 ===");
        // 람다 - 5개 타입 매개변수 (Person, Integer, String, Integer, 반환값 String)
        // apply 메서드는 4개 매개변수를 받음
        QuadFunction<Person, Integer, String, Integer, String> func3 =
            (Person p, Integer number, String location, Integer age) -> p.introduceWithFullDetails(number, location, age);
        System.out.println("func3 = " + func3.apply(person, 2, "Seoul", 25));

        // 메서드 참조 - 5개 타입 매개변수
        // 첫 번째: Person (인스턴스)
        // 두 번째: Integer (메서드 첫 번째 인자)
        // 세 번째: String (메서드 두 번째 인자)
        // 네 번째: Integer (메서드 세 번째 인자)
        // 다섯 번째: String (반환값)
        QuadFunction<Person, Integer, String, Integer, String> func4 = Person::introduceWithFullDetails;
        System.out.println("func4 = " + func4.apply(person, 3, "Busan", 30));
    }

}

