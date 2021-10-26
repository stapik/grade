package x5;

import java.util.*;

public class Salary {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(57, 45, 54, 48, 23, 46, 89, 67, 25, 78, 59, 71);
        System.out.println(getResult(list, 611));
    }

    public static int getResult(List<Integer> cash, int s) {
        PriorityQueue<Integer> set = new PriorityQueue<>(cash);
        System.out.println(set);
        int count, item, div, maxSum = 0;

        if (set.size() == 0) {
            return 0;
        }

        while (s != 0) {
            item = set.poll();
            System.out.println(item);

            div = s % 3;
            count = div == 0 ? 3 : div;
            item += count;
            set.add(item);
            s -= count;
            maxSum = Math.max(item, maxSum);
        }
        TreeSet<Integer> n = new TreeSet<>(set);
        int finalMaxSum = maxSum;
        System.out.println(n);
        System.out.println(set);
        System.out.println(maxSum);
        return (int) set.stream().filter(i -> i < n.last()).count();
    }
}
