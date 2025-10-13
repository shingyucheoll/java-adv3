package lambda.lambda1;

// SAM(Single Abstract Method)
@FunctionalInterface
public interface SamInterface {
    void run();

    // void gogo();  // 컴파일 에러!
}
