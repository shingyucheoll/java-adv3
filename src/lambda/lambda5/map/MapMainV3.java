package lambda.lambda5.map;

import static lambda.lambda5.map.StringToIntegerMapper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");
        System.out.println("strings = " + strings);

        // 문자열을 숫자로 변환
        List<Integer> numbers = map(strings, s -> Integer.valueOf(s));
        System.out.println("numbers = " + numbers);

        // 문자열을 길이로 반환
        List<Integer> toLength = map(strings, s -> s.length());
        System.out.println("integers = " + toLength);
    }


}
