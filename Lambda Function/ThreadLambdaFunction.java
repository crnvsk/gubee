public class ThreadLambdaFunction {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Thread com lambda!");
        new Thread(r).start();
    }
}

