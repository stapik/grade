package grade;

import java.util.concurrent.CountDownLatch;

public class MemoryLeakExample {
    private static final java.util.List<String> storage = new java.util.ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            String data = "Datasdfsdfsfdfdfsdf" + i; // Создаем новый объект
            storage.add(data); // Добавляем в коллекцию
            // Утечка: коллекция не очищается!
        }
        System.out.println("Done. Size: " + storage.size());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
        // storage.clear(); // Закомментировано специально
    }
}