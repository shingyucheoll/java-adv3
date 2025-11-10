package methodref;

import java.util.List;

import lambda.lambda5.mystream.MyStreamV3;

public class MethodRef5 {

    static void main() {
        List<Person> personList = List.of(
            new Person("Kim"),
            new Person("Park"),
            new Person("Lee")
        );

        List<String> result1 = MyStreamV3.of(personList)
            .map(person -> person.introduce())
            .map(str -> str.toUpperCase())
            .toList();
        System.out.println("result1 = " + result1);


        List<String> result2 = MyStreamV3.of(personList)
            .map(Person::introduce)
            .map(String::toUpperCase)
            .toList();
        System.out.println("result2 = " + result2);
    }
}

