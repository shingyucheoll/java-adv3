package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx2 {

    static void main() {

        /*
        MethodRefEx1 에서는 매개변수가 없고 반환 타입만 있었기 때문에 Supplier 사용 ( 입력 x 반환 o )

        MethodRefEx2 현재 예제에서는 매개변수가 추가되었기 때문에 Supplier 를 Function 으로 변경 ( 입력 o 반환 o )
         */

        // 정적 메서드 참조 ( 매개변수 o )
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);

        // 클래스::정적메서드 ( 매개변수 생략이 가능하다 )
        Function<String, String> staticMethod2 = Person::greetingWithName;

        System.out.println("staticMethod1 = " + staticMethod1.apply("Kim"));
        System.out.println("staticMethod1 = " + staticMethod2.apply("Kim"));

        // 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Function<Integer, String> instanceMethod1 = n -> person.introduceWithNumber(n);
        // 객체::인스턴스메서드 ( 매개변수 생략이 가능하다! )
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;

        System.out.println("instanceMethod1.get() = " + instanceMethod1.apply(1));
        System.out.println("instanceMethod2.get() = " + instanceMethod2.apply(1));

        // 생성자 참조 -> 생성자 반환
        // + Function 은 입력값이 있기 때문에 매개변수가 있는 생성자를 찾아서 생성합니다. - 타입 추론
        Function<String, Person> newPerson1 = name -> new Person(name);
        Function<String, Person> newPerson2 = Person::new;

        System.out.println("newPerson1.get() = " + newPerson1.apply("Shin").getName());
        System.out.println("newPerson2.get() = " + newPerson2.apply("Shin").getName());

        /*
        매개변수가 있는 메서드에서 매개변수 생략이 가능한 이유는
        함수형 인터페이스에서 입력값이 있는 경우에
        컴파일러가 함수형 인터페이스에서 선언한 매개변수와 일치하는 메서드를 참조하기 때문에 해결된다.
         */

    }
}
