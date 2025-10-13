package lambda.lambda2;

import lambda.MyFunction;

// 2. 람다를 메서드(함수)에 전달하기
public class LambdaPassMain2 {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("변수를 통해 전달");
        calculate(add);
        calculate(sub);

        System.out.println("람다를 직접 전달합니다.");
        calculate((a, b) -> a + b);
        calculate((a, b) -> a - b);

        /**
         * 변수를 통해 전달하는 방식 분석
         * 코드 : MyFunction add = (a, b) -> a + b;
         * 분석 : MyFunction add = x001; -> 람다의 인스턴스를 즉시 생성합니다.
         * 코드 : calculate(add);
         * 분석 : calculate(x001);  ->  람다의 인스턴스를 전달합니다.
         * 실행 분석 : void calculate(MyFunction function) -> 여기에서 function = x001
         */

        /**
         * 람다를 직접 전달하는 방식 분석
         * 코드 : calculate((a, b) -> a + b);
         * 분석 : calculate(x001);  ->  람다의 인스턴스를 생성과 동시에 전달합니다.
         * 실행 분석 : void calculate(MyFunction function = x001) 메서드 호출하고 매개변수에 참조값을 대입합니다.
         */

    }

    static void calculate(MyFunction function) {
        int a = 1;
        int b = 2;

        System.out.println("게산 시작");
        int result = function.apply(a, b);
        System.out.println("계산 결과 = " + result);
    }
}
