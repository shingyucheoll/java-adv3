package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {

    static void main() {

        List<Student> students = List.of(
            new Student("Apple", 100),
            new Student("Banana", 80),
            new Student("Berry", 50),
            new Student("Tomato", 40)
        );

        List<String> result = MyStreamV3.of(students)
            .filter(s -> s.getScore() >= 80)
            .map(s -> s.getName())
            .toList();

        System.out.println("result = " + result);

        // 외부 반복
        for (String name : result) {
            System.out.println("s = " + name);
        }

        // 내부 반복 - Internal Iteration
        MyStreamV3.of(students)
            .filter(s -> s.getScore() >= 80)
            .map(s -> s.getName())
            // 정리된 데이터를 consumer 를 사용해서 즉시 출력합니다. ( consumer = accept 를 사용 - 소비 )
            .forEach(name -> System.out.println("name = " + name));
            // 전부 소비했기 때문에 반환값이 없습니다.
    }
}