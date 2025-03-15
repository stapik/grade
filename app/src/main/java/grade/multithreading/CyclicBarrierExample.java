package grade.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    /**
     * 3 parties = 3 await
     * делаем барьер из кол-ва await, как только барьер проходим, выполняется barrierAction
     * @param args
     * @throws InterruptedException
     * @throws BrokenBarrierException
     */
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("cyclicBarrier barrierAction");
        });
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5_000);
                System.out.println("cyclicBarrier t1 before");
                cyclicBarrier.await();
                System.out.println("cyclicBarrier t1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
                System.out.println("cyclicBarrier t2 before");
                cyclicBarrier.await();
                System.out.println("cyclicBarrier t2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        System.out.println("main. Waiting for threads to finish");
        System.out.println(cyclicBarrier.getParties());
        cyclicBarrier.await();

        Thread.sleep(1_000);
        System.out.println("main. cyclicBarrier completed");
        System.out.println(cyclicBarrier.getParties());
    }
}
