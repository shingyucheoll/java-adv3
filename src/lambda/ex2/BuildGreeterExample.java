package lambda.ex2;

public class BuildGreeterExample {

    public static StringFunction buildGreeter(String greeting) {
        // greeting = "Hello" 가 고정된 상태로

        return name -> greeting + " " + name;
        // StringFunction 의 apply(String name) 메서드를
        // "Hello" + " " + name 으로 구현한 객체 반환
    }




    public static void main(String[] args) {

        StringFunction helloGreeter = buildGreeter("Hello");
        // StringFunction helloGreeter = new StringFunction() {
        //     private String greeting = "Hello";  // 캡처된 값
        //
        //     @Override
        //     public String apply(String name) {
        //         return greeting + " " + name;  // Hello + " " + name
        //     }
        // };


        StringFunction hiGreeter = buildGreeter("Hi");

        // ### 메모리 상태:
        // ```
        // helloGreeter 객체:
        // - 타입: StringFunction 구현체
        // - 캡처된 변수: greeting = "Hello"
        //     - apply 메서드: name -> "Hello" + " " + name
        //
        // hiGreeter 객체:
        // - 타입: StringFunction 구현체
        // - 캡처된 변수: greeting = "Hi"
        //     - apply 메서드: name -> "Hi" + " " + name

        helloGreeter.apply("Java");     // Hello, Java
        System.out.println("hiGreeter = " + helloGreeter);
        hiGreeter.apply("Lambda");      // Hi, Lambda
        System.out.println("hiGreeter = " + hiGreeter);

    }
}
