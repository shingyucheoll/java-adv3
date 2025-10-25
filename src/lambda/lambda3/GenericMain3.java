package lambda.lambda3;

public class GenericMain3 {

    public static void main(String[] args) {

        ObjectFunction upperCase = new ObjectFunction() {
            @Override
            public Object apply(Object s) {
                return ((String)s).toUpperCase();
            }
        };
        String hello = (String)upperCase.apply("Hello");
        System.out.println("hello = " + hello);

        ObjectFunction square = new ObjectFunction() {
            @Override
            public Object apply(Object n) {
                return (Integer)n * (Integer)n;
            }
        };
        Integer apply = (Integer)square.apply(5);
        System.out.println("apply = " + apply);

    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object s);
    }
}
