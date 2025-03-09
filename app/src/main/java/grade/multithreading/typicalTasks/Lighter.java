package grade.multithreading.typicalTasks;

import java.util.concurrent.CopyOnWriteArrayList;

public class Lighter {

    static class Foo {
        final CopyOnWriteArrayList<Integer> data = new CopyOnWriteArrayList<>();

        void first() {
            data.add(1);
            System.out.println(data.size());
        }

        void second() {
            data.add(2);
            System.out.println(data.size());
        }

        void third() {
            data.add(3);
            System.out.println(data.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread t1 = new Thread(foo::third);

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            foo.second();
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            foo.first();
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
