package lambda.start;

import java.util.Random;

import lambda.Procedure;

public class Ex1RefMain {

    public static void main(String[] args) {
        Procedure dice = new Dice();
        Procedure sum = new Sum();

        hello(dice);
        hello(sum);
    }

    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    static class Dice implements Procedure {

        @Override
        public void run() {

            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);

        }
    }

    static class Sum implements Procedure {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }
}