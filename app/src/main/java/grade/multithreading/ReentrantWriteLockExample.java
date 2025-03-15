package grade.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantWriteLockExample {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int value;

    public int readValue() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeValue(int newValue) {
        lock.writeLock().lock();
        try {
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * читать могут несколько потоков, писать может только один.
     * Если один поток пишет, остальные на чтение/запись ждут
     */
    public static void main(String[] args) {
        ReentrantWriteLockExample obj = new ReentrantWriteLockExample();
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                if(lock.isWriteLocked()) {
                    System.out.println(Thread.currentThread().getName() + ": write locked");
                } else {
                    obj.readValue();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                obj.writeValue(i);
            }
        }).start();
    }
}
