package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

public class Ex2_Student {

    /*
    80점 이상인 학생의 이름만 출력하는 문제를
    direct 와 lambda ( Filter, Map ) 을 사용하여 풀어봅니다.
     */
    static void main() {

        List<Student> students = List.of(
            new Student("Apple", 100),
            new Student("Banana", 80),
            new Student("Berry", 50),
            new Student("Tomato", 40)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }



    private static List<String> direct(List<Student> students) {
        List<String> names = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                names.add(student.getName());
            }
        }
        return names;
    }

    private static List<String> lambda(List<Student> students) {

        List<Student> highScoreStudents = GenericFilter.filter(students, s -> s.getScore() >= 80);

        return GenericMapper.map(highScoreStudents, Student::getName);

    }
}
