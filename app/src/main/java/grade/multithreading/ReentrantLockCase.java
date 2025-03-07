package grade.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock работает аналогично synchronized, подходит для эффективной работы в среде с высокой конкурентностью
 * к данным, более гибкий способ работы доступом к общему ресурсу
 */
public class ReentrantLockCase {

    private final ReentrantLock lock = new ReentrantLock();

    public void safeMethod() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " захватил блокировку");

        try {
            Thread.sleep(7_000);
            // Критическая секция
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " убрал блокировку");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockCase example = new ReentrantLockCase();
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(example.lock.isLocked()){
                System.out.printf("залочено, очередь: %s \n", example.lock.getQueueLength());
            }
        }).start();
        new Thread(example::safeMethod).start();
        new Thread(example::safeMethod).start();
    }
}
