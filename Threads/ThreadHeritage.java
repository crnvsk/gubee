package Threads;

class MinhaThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando thread: " + i);
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadHeritage {
    public static void main(String[] args) {
        MinhaThread thread1 = new MinhaThread();
        thread1.start(); // Inicia a execução da thread

        System.out.println("Thread principal finalizada.");
    }
}

