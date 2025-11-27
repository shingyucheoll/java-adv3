package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {

    static void main() {
        List<Student> students = List.of(
            new Student("Kim", 1, 95),
            new Student("Park", 1, 90),
            new Student("Lee", 2, 85),
            new Student("Ha", 2, 85),
            new Student("Java", 3, 85),
            new Student("Shin", 3, 100),
            new Student("Hoo", 3, 85)
        );

        // 1단계: 학년별로 학생들을 그룹화
        Map<Integer, List<Student>> collect1 = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);

        // 2단계: 학년별로 가장 점수가 높은 학생을 구하기
        Map<Integer, Optional<Student>> collect2 = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.reducing(
                    (s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2
                )
            ));
        System.out.println("collect2 = " + collect2);

        // 3단계: 학년별로 가장 점수가 높은 학생을 구하기 ( maxBy 사용 )
        Map<Integer, Optional<Student>> collect3 = students.stream()
            .collect(Collectors.groupingBy(
                    Student::getGrade,
                    Collectors.maxBy(
                        // (s1, s2) -> s1.getScore() > s2.getScore() ? 1 : -1)
                        // Comparator.comparingInt(student -> student.getScore())
                        Comparator.comparingInt(Student::getScore) // 점수가 같은 대상이 있으면 결과값이 달라짐
                    )
                )
            );
        System.out.println("collect3 = " + collect3);

        // 4단계: 학년별로 가장 점수가 높은 학생의 이름을 구하기
        // 학년별 그룹화 -> 그룹별 가장 점수가 높은 학생 구하기 -> 그룹별 가장 점수가 높은 학생의 이름을 구하기
        Map<Integer, String> collect4 = students.stream()
            .collect(Collectors.groupingBy(
                    Student::getGrade,                  // 학년별 그룹화
                    Collectors.collectingAndThen(       // collecting 작업을 끝낸 다음 ~ 해라 ( AndThen )

                        Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                        // 가장 점수가 높은 학생을 구하고 ( reducing )
                        sOpt -> {            // 결과로 나온 학생 ( Optional )
                            Student student = sOpt.get();   // 학생의 이름을 반환합니다.
                            return student.getName();
                        }
                    )
                )
            );

        /*
        Map 에 어떤 값을 담아서 반환하는지 collect3 과 비교하고,
        collect4 는 작업 후 한 번 더 후처리까지 진행된 케이스이며
        AndThen -> 이미 한 번 수집한 결과를 추가 가공 하거나 최종 타입으로 변환할 때 사용합니다. ( 예시로 Optional -> String )
         */
        System.out.println("collect4 = " + collect4);


    }
}