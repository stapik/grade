package yandex.wob;

import java.util.*;

public class TechnicalDebt {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int tasksCount = inp.nextInt(), robotDays = inp.nextInt(), k = inp.nextInt() - 1, item;
        NavigableSet<Integer> tasks = new TreeSet<>();
        while (tasksCount != 0) {
            tasks.add(inp.nextInt());
            tasksCount--;
        }

        while (k != 0) {
            item = tasks.pollFirst();
            item += robotDays;
            tasks.add(item);
            k--;
        }

        System.out.println(tasks.first());
        inp.close();
    }
}
