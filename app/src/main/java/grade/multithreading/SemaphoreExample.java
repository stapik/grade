package grade.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    /**
     * Семафор инициализируется с максимальным кол-вом потоков, которые могут иметь одновременный доступ к ресурсу,
     * остальные потоки будут ожидать освобождения места для работы
     */
    public static void main(String[] args) {
        // Создаём семафор с ограничением на 2 потока
        Semaphore semaphore = new Semaphore(2);

        // Потоки, которые будут пытаться захватить семафор
        Runnable task = () -> {
            try {
                // Попытка захватить семафор
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " получил доступ к ресурсу");

                // Имитируем выполнение работы
                Thread.sleep((long) (Math.random() * 1000) + 1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Освобождаем семафор, увеличив счётчик
                System.out.println(Thread.currentThread().getName() + " освобождает ресурс");
                semaphore.release();
            }
        };

        // Создание и запуск нескольких потоков
        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}
