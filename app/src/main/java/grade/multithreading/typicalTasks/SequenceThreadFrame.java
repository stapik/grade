package grade.multithreading.typicalTasks;

import java.util.concurrent.CopyOnWriteArrayList;

public class SequenceThreadFrame {

    static class LockObject {

        boolean firstWorking = false;
        boolean secondWorking = false;

        public synchronized void firstWait() {
            try {
                while (secondWorking) {
                    wait();
                }
                firstWorking = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void firstDone() {
            firstWorking = false;
            secondWorking = true;
            notify();
        }

        public synchronized void secondWait() {
            try {
                while (firstWorking) {
                    wait();
                }
                secondWorking = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void secondDone() {
            secondWorking = false;
            firstWorking = true;
            notify();
        }
    }

    public static void main(String[] args) {
        sequence();
    }

    public static void sequence() {
        var out = new CopyOnWriteArrayList<String>();
        var lock = new LockObject();

        var first = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.firstWait();
                out.add(String.valueOf(i));
                lock.firstDone();
            }
        });
        var second = new Thread(() -> {
            for (int i = 20; i < 30; i++) {
                lock.secondWait();
                out.add(String.valueOf(i));
                lock.secondDone();
            }
        });

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf(out.toString());
    }
}
