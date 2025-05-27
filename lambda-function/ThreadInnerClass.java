package LambdaFunction;

public class ThreadInnerClass {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread com classe interna!");
            }
        };
        new Thread(r).start();
    }
}
