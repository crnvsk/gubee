package LambdaFunction;

public class LambdaInsideConstructor {
    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("Thread com lambda dentro do construtor!")).start();
    }
}
