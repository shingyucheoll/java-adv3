package methodref;

public class Person {

    private String name;
    private String address;
    private Integer age;


    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    // 정적 메서드
    public static String greeting() {
        return "Hello";
    }

    // 정적 메서드
    public static String greetingWithName(String name) {
        return "Hello" + name;
    }

    public String getName() {
        return name;
    }

    // 인스턴스 메서드
    public String introduce() {
        return "I am " + name;
    }

    // 인스턴스 메서드 ( 파라미터 있음 )
    public String introduceWithNumber(int number) {
        return "I am " + name + ", my number is " + number;
    }

    // 인스턴스 메서드 ( 파라미터 2개 )
    public String introduceWithDetails(int number, String location) {
        return "I am " + name + ", my number is " + number + ", from " + location;
    }

    // 인스턴스 메서드 ( 파라미터 3개 )
    public String introduceWithFullDetails(int number, String location, int age) {
        return "I am " + name + ", my number is " + number + ", from " + location + ", age " + age;
    }
}
