package grade.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5_000);
                countDownLatch.countDown();
                System.out.println("countDown t1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
                countDownLatch.countDown();
                System.out.println("countDown t2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        System.out.println("main. Waiting for threads to finish");
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();

        Thread.sleep(1_000);
        System.out.println("main. Count down completed");
        System.out.println(countDownLatch.getCount());
    }
}
