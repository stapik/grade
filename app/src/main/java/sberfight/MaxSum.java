package sberfight;

import java.util.*;

public class MaxSum {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList(2))); // 2
        System.out.println(getResult(Arrays.asList(-1, 5, -10))); // 5
        System.out.println(getResult(Arrays.asList(-10, 100, -100, 1000))); // 1000
        System.out.println(getResult(Arrays.asList(4, 2, 8, -5, 2))); // 4 2 8
        System.out.println(getResult(Arrays.asList(2, 1, -5, 3, 8, 2, -3, 4, 1, -5))); // 3 8 2 -3 4 1
    }

    public static List<Integer> getResult(List<Integer> numb) {
        int fromIndex = 0, maxSum = Integer.MIN_VALUE, tempSum = 0;
        TreeMap<Integer, int[]> sumMap = new TreeMap<>();

        for (int i = 0; i < numb.size(); i++) {
            tempSum += numb.get(i);
            if (tempSum > maxSum) {
                maxSum = tempSum;
                sumMap.put(maxSum, new int[]{fromIndex, i + 1});
            }
            if (tempSum <= 0) {
                tempSum = 0;
                fromIndex = i + 1;
            }
        }

        int[] result = sumMap.lastEntry().getValue();

        return numb.subList(result[0], result[1]);
    }
}