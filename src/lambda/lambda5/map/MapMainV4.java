package lambda.lambda5.map;

import static lambda.lambda5.map.StringToIntegerMapper.*;

import java.util.List;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");
        System.out.println("strings = " + strings);

        // 문자열을 숫자로 변환
        List<Integer> numbers = StringToIntegerMapper.map(strings, s -> Integer.valueOf(s));
        System.out.println("numbers = " + numbers);

        // 문자열을 길이로 반환
        List<Integer> toLength = StringToIntegerMapper.map(strings, s -> s.length());
        System.out.println("integers = " + toLength);
    }


}
