package lambda.ex3;

public class GenericMain4 {

    public static void main(String[] args) {

        // <인자, 반환>
        GenericFunction<String, String> upperCase = s -> s.toUpperCase();

        String hello = upperCase.apply("Hello");
        System.out.println("hello = " + hello);

        // new GenericFunction<>() {}
        // new GenericFunction() {}     -> 예외발생...이유?
        GenericFunction<Integer, Integer> square = n -> n * n;

        Integer apply = square.apply(5);
        System.out.println("apply = " + apply);

    }

    // T를 넣어서 R을 반환 T, R / R, T ??
    // T : 매개변수의 타입
    // R : 반환 타입
    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}