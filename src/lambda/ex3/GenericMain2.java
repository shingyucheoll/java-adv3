package lambda.ex3;

public class GenericMain2 {

    public static void main(String[] args) {

        ObjectFunction upperCase = s -> ((String)s).toUpperCase();
        // 오브젝트를 파라미터로 받고, 오브젝트를 반환할 때 에러가 난다..!
        // String 타입은 Object 타입을 담을 수 없으니,,. 자식은 부모를 담을 수 없다.
        String hello = (String)upperCase.apply("Hello");
        System.out.println("hello = " + hello);

        ObjectFunction square = n -> (Integer)n * (Integer)n;
        Integer apply = (Integer)square.apply(5);
        System.out.println("apply = " + apply);

    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object s);
    }
}
