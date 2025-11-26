package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {

    static void main() {
        List<Student> students = List.of(
            new Student("Kim", 1, 85),
            new Student("Park", 1, 85),
            new Student("Lee", 2, 85),
            new Student("Shin", 3, 100),
            new Student("Hoo", 3, 85),
            new Student("Ha", 2, 85),
            new Student("Java", 3, 85)
        );

        Map<Integer, List<Student>> collect1 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,          // 그룹화 기준 : 학번
                Collectors.toList()         // 다운 스트림 : 학생을 리스트로 수집
            ));

        System.out.println("collect1 = " + collect1);

        // 다운스트림에서 toList() 생략 가능
        Map<Integer, List<Student>> collect2 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade
                // Collectors.toList()         toList 생략 가능
            ));

        System.out.println("collect2 = " + collect2);

        // 2단계 : 학년별로 학생들의 이름을 출력하기
        Map<Integer, List<String>> collect3 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                /*
                다운스트림1 : 학생의 이름만 추출 ( s -> s.getName )
                다운스트림2 : 이후 toList 로 수집
                 */
                Collectors.mapping(Student::getName, Collectors.toList())
            ));
        System.out.println("collect3 = " + collect3);

        // 3단계 : 학년별로 학생들의 수를 출력하기
        Map<Integer, Long> collect4 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.counting()
            ));
        System.out.println("collect4 = " + collect4);

        // 4단계 : 학년별로 학생들의 평균 성적 출력하기
        Map<Integer, Double> collect5 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.averagingInt(Student::getScore)      // 학년별로 학생들의 점수의 평균을 구합니다.
            ));

        System.out.println("collect5 = " + collect5);

    }
}
