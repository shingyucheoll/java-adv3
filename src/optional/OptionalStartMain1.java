package optional;

import java.util.HashMap;
import java.util.Map;

public class
OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    // static Block 은 application 에서 선언된 class 가 loading 될 때 초기화 됩니다.
    static {
        map.put(1L, "Kim");
        map.put(2L, "Seo");
    }

    static void main() {
        findAndPrint(1L);   // 값이 있는 경우
        findAndPrint(3L);   // 값이 없는 경우

    }

    // 이름이 있으면 이름을 대문자로 출력, 없으면 "UNKNOWN" 을 출력해라
    static void findAndPrint(Long id) {
        String name = findNameById(id);

        // System.out.println(name.toUpperCase()); // 3을 조회하게 될 경우 null.toUpperCase() 와 같이 선언되기 떄문에 NPE 발생
        if (name != null) {
            System.out.println(id + ": " + name.toUpperCase());
        } else {
            System.out.println(id + ": UNKNOWN");
        }
    }


    static String findNameById(Long id) {
        return map.get(id);
    }

}
