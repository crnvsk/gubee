package Threads;

class MinhaRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando Runnable: " + i);
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        Thread thread2 = new Thread(new MinhaRunnable());
        thread2.start(); // Inicia a thread

        System.out.println("Thread principal finalizada.");
    }
}
