package methodref;

import java.util.function.Supplier;

public class MethodRefEx1 {

    static void main() {

        // 정적 메서드 참조
        Supplier<String> staticMethod1 = () -> Person.greeting();
        Supplier<String> staticMethod2 = Person::greeting;  // 클래스::정적메서드

        System.out.println("staticMethod1 = " + staticMethod1.get());
        System.out.println("staticMethod2 = " + staticMethod2.get());

        // 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Supplier<String> instanceMethod1 = () -> person.introduce();
        Supplier<String> instanceMethod2 = person::introduce;   // 객체::인스턴스메서드

        System.out.println("instanceMethod1.get() = " + instanceMethod1.get());
        System.out.println("instanceMethod2.get() = " + instanceMethod2.get());

        // 생성자 참조
        Supplier<Person> newPerson1 = () -> new Person();
        Supplier<Person> newPerson2 = Person::new;

        System.out.println("newPerson1.get() = " + newPerson1.get());
        System.out.println("newPerson2.get() = " + newPerson2.get());

        /*
        Supplier : 입력 X 반환 O
        Supplier 는 "공급자" 라는 의미로, 요청을 할 때 마다 값을 공급해주는 역할을 합니다.
        "get" 은 "얻다" 라는 의미로, supplier 로부터 값을 얻어온다는 개념을 표현합니다.
        예) 랜덤값을 제공하는 supplier 는 호출할 때 마다 새로운 랜덤 값을 공급합니다.
        -> 객체나 값을 생성하거나 지연 초기화 등에 주로 사용됩니다.
         */

    }
}
