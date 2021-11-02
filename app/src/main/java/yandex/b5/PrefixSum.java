package yandex.b5;

import java.util.*;

public class PrefixSum {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Scanner paramsScan = new Scanner(inp.nextLine());
        Scanner arrayScan = new Scanner(inp.nextLine());
        int arraySize = paramsScan.nextInt(), countRequests = paramsScan.nextInt(), from, to;
        ArrayList<Long> prefixSum = new ArrayList<>();
        paramsScan.close();

        prefixSum.add(0L);
        while (arraySize != 0) {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + arrayScan.nextInt());
            arraySize--;
        }
        arrayScan.close();

        while (countRequests != 0) {
            from = inp.nextInt() - 1;
            to = inp.nextInt();
            System.out.println(prefixSum.get(to) - prefixSum.get(from));
            countRequests--;
        }

        inp.close();
    }
}
