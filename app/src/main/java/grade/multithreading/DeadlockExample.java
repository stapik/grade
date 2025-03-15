package grade.multithreading;

public class DeadlockExample {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    /**
     * первый поток блокирует монитор объекта LOCK1, второй поток блокирует монитор объекта LOCK2
     * первый поток в ожидании монитора LOCK2, второй в ожидании LOCK1
     * как исправить? нужно блокировать монитор в одном и том же порядке
     */
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println(Thread.currentThread().getName() + ": Lock 1");

                synchronized (LOCK2) {
                    System.out.println(Thread.currentThread().getName() + ": Lock 2");
                }
            }
        });
        Thread threadTwo = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println(Thread.currentThread().getName() + ": Lock 2");
                synchronized (LOCK1) {
                    System.out.println(Thread.currentThread().getName() + ": Lock 1");
                }
            }
        });
        threadOne.start();
        threadTwo.start();

        Thread.sleep(10000);
    }
}
