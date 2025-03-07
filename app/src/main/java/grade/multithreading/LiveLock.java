package grade.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class LiveLock {

    private static AtomicInteger counter = new AtomicInteger(10);

    private static class ThreadPlus implements Runnable {

        public void run() {
            while (counter.incrementAndGet() < 20) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("plus: " + counter);
            }

        }
    }

    private static class ThreadMinus implements Runnable {

        public void run() {

            while (counter.decrementAndGet() > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("minus: " + counter);

            }
        }
    }

    public static void main(String[] args) {
        Thread threadPlus = new Thread(new ThreadPlus());
        Thread threadMinus = new Thread(new ThreadMinus());
        threadPlus.start();
        threadMinus.start();
    }
}
