package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMapMain {

    static void main() {

        List<List<Integer>> outerList = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5, 6)
        );
        System.out.println("outerList = " + outerList);

        // for
        List<Integer> forResult = new ArrayList<>();
        for (List<Integer> list : outerList) {
            for (Integer i : list) {
                forResult.add(i);
            }
        }
        System.out.println("forResult = " + forResult);

        // Stream map
        List<Stream<Integer>> mapResult = outerList.stream()
            .map(list -> list.stream())
            .toList();

        // 내부에 stream 이 3개가 생성됩니다. Stream<Stream<>> 형태 이기 때문에
        // mapResult = [
        // java.util.stream.ReferencePipeline$Head@30f39991,
        // java.util.stream.ReferencePipeline$Head@452b3a41,
        // java.util.stream.ReferencePipeline$Head@4a574795
        // ]
        System.out.println("mapResult = " + mapResult);

        // Stream flatMap
        /**
         * 1. outerList = List<List<Integer>>
         * 2. outerList.stream() 호출 시 Stream<List<Integer>> 형태로 변경
         * 3. flatMap(list -> list.stream()) 호출 시 동작 과정
         * 3.1 list -> list.stream() 을 통해 Stream<> 내부의 List<Integer> 리스트를 Stream<Integer> 형태로 변경합니다.
         * 3.2 이후 flatMap(Stream<Integer>) 를 실행하여 내부의 여러 Stream<Integer> 리스트를 하나의 숫자로 합치게 됩니다.
         * 3.3 flatMap() 까지 실행되고 나면 Stream<Integer> 와 같이 내부 모든 객체가 하나의 값으로 합쳐집니다.
         * 4. Stream<Integer> 에서 .toList 를 통해 List<Integer> 로 변경하여 응답하게 됩니다.
         *
         * 따라서 요약하면,
         * flatMap은 중첩 구조 ( 컬렉션 안의 컬렉션, 배열 안의 배열 등 ) 를 일차원으로 펼치는데 사용됩니다.
         * 사용 예시로 문자열 리스트들이 들어있는 리스트를 평탄화 하게 되면 하나의 연속된 문자열을 만들 수 있게 됩니다.
         */
        List<Integer> flatMapResult = outerList.stream()
            .flatMap(list -> list.stream())
            .toList();

        System.out.println("flatMapResult = " + flatMapResult);

    }
}
