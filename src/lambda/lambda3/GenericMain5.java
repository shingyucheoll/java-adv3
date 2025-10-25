package lambda.lambda3;

public class GenericMain5 {

    public static void main(String[] args) {

        GenericFunction<String, String> toUpperCase = str -> str.toUpperCase();
        GenericFunction<String, Integer> stringLength = str -> str.length();
        GenericFunction<Integer, Integer> square = x -> x * x;
        GenericFunction<Integer, Boolean> isEven = num -> num % 2 == 0;

        System.out.println("toUpperCase = " + toUpperCase.apply("hello"));
        System.out.println("stringLength = " + stringLength.apply("hello"));
        System.out.println("square = " + square.apply(5));
        System.out.println(isEven.apply(3));

    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}

