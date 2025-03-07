package grade.multithreading;

public class InterruptCase {

    /**
     * Вызов метода Thread.interrupt() ставит флаг о прерывании потока, код в потоке должен самостоятельно разбираться
     * с этим флагом и завершать свой поток. В Java нельзя остановить поток.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Работаю...");
            }
            System.out.println("Поток завершён.");
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt(); // Устанавливаем флаг прерывания (не выбрасывает исключение)

        testExc();
    }

    /**
     * Если поток находится в состоянии ожидания (wait, join, sleep) и вызывается метод interrupt этого потока,
     * то в потоке выбрасывается исключение InterruptedException
     */
    private static void  testExc () throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // Поток засыпает на 10 секунд
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Поток прерван, исключение будет выброшено
                System.out.println("Поток был прерван!");
            }
        });

        thread.start();

// Через 2 секунды вызываем interrupt()
        Thread.sleep(2000);
        thread.interrupt();  // Прерывает поток, выбрасывая InterruptedException
    }
}
