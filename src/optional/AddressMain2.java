package optional;

import java.util.Optional;

import optional.model.Address;
import optional.model.User;

public class AddressMain2 {

    static void main() {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
            System.out::println,                // 값이 있으면 해당 값을 출력 ( s -> System.out.println(s) )
            () -> System.out.println("Unknown") // 없으면 출력
        );
    }

    static Optional<String> getUserStreet(User user) {

        return Optional.ofNullable(user)  // user 가 null 일 수 있기 때문에 ofNullable 사용
            .map(User::getAddress)
            .map(Address::getStreet);
        // 여기서 map 체이닝 중간에 null 일 경우 Optional.empty() 반환

        // Optional.empty() 를 반환하지 않고
        // nullable 한 값에 직접 참조해서 사용할 경우 NPE 발생
        // .map(user1 -> user1.getAddress().getStreet())



    }
}
