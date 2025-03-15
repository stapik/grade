package grade.multithreading;

public class HappensBeforeExample {
    static int x = 0;
    static volatile boolean flag = false;

    /**
     * Volatile не заставляет поток "ждать" — он лишь обеспечивает корректную видимость данных,
     * если запись и чтение происходят в нужном порядке.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            x = 42; // шаг 1
            flag = true; // шаг 2: шаг 1 happens-before шаг 2 (правило программы)
        });

        Thread t2 = new Thread(() -> {
            if (flag) { // шаг 3: шаг 2 happens-before шаг 3 (правило volatile)
                System.out.println(x); // шаг 4: шаг 3 happens-before шаг 4 (правило программы)
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // Поток 2 увидит x = 42, если увидит flag = true, возможно,
        // что второй поток быстрее закончит работу и ничего не выведет
        /*
         * Без happens-before JVM могла бы переупорядочить операции (например, сначала flag = true, затем x = 42) и
         * t2 увидел бы x = 0. JMM с volatile или synchronized гарантирует порядок и видимость
         */
    }
}
