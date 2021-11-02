package yandex.b5;

import java.util.*;

public class PrefixSum {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int arraySize = inp.nextInt(), countRequests = inp.nextInt(), from, to;
        ArrayList<Long> prefixSum = new ArrayList<>();

        prefixSum.add(0L);
        while (arraySize != 0) {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + inp.nextInt());
            arraySize--;
        }

        while (countRequests != 0) {
            from = inp.nextInt() - 1;
            to = inp.nextInt();
            System.out.println(prefixSum.get(to) - prefixSum.get(from));
            countRequests--;
        }

        inp.close();
    }
}
