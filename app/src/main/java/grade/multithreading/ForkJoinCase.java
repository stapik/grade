package grade.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCase {

    static class SumTask extends RecursiveTask<Integer> {
        private final int[] arr;
        private final int start, end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) { // Базовый случай
                return arr[start] + (start + 1 < end ? arr[start + 1] : 0);
            }
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(arr, start, mid);
            SumTask rightTask = new SumTask(arr, mid, end);

            leftTask.fork(); // Разделение задачи
            return rightTask.compute() + leftTask.join(); // Объединение результатов
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        SumTask task = new SumTask(array, 0, array.length);
        int sum = pool.invoke(task);
        System.out.println("Sum: " + sum);
    }
}
