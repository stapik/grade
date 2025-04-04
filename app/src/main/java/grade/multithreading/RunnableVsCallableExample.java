package grade.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.*;

public class RunnableVsCallableExample {

    /**
     * Callable & Runnable интерфейсы
     * Runnable не возвращает значения и не выбрасывает checked исключения
     * Callable возвращает Future и можно получить результат
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable runnable = () -> System.out.println("Hello World from Runnable");

        Callable<String> callable = () -> {
            Thread.sleep(5_000);
            System.out.println("Hello World from Callable");
            return "result";
        };
        executor.submit(runnable);
        Future<String> future = executor.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();

        FutureTask<String> futureTask = new FutureTask<>(callable);
        System.out.printf(futureTask.get());
    }
}
