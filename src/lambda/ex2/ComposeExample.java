package lambda.ex2;

public class ComposeExample {

    private static MyTransformer compose(MyTransformer toUpper, MyTransformer addDeco) {
        return s -> addDeco.transform(toUpper.transform(s));
    }

    public static void main(String[] args) {

        MyTransformer toUpper = String::toUpperCase;

        MyTransformer addDeco = s -> "**" + s + "**";

        MyTransformer composeFunc = compose(toUpper, addDeco);

        // 실행
        String result = composeFunc.transform("hello");
        System.out.println(result);  // "**HELLO**"

    }


}
