package grade.multithreading;

public class RaceConditionExample {

    private static int count = 0;

    /**
     * Результат зависит от порядка действий выполняемых потоков. Хотим получить count = 20 000, но видим другой результат, так как
     * Первый поток прибавил 1, сохраняет, второй поток перезаписывает переменную своим значением. Первый берет значение второго потока
     * и так далее.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);

        Thread.sleep(10000);
    }
}
