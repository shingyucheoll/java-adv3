package lambda.lambda3;

public class GenericMain1 {

    public static void main(String[] args) {

        StringFunction upperCase = s -> s.toUpperCase();
        String hello = upperCase.apply("Hello");
        System.out.println("hello = " + hello);

        NumberFunction square = n -> n * n;
        Integer apply = square.apply(5);
        System.out.println("apply = " + apply);

    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer i);
    }
}
