package yandex.b5;

import java.util.Scanner;

public class MaxSum {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int prefixSize = inp.nextInt();
        long prevValue = inp.nextInt(), maxSum = prevValue, prefixSum = 0, nextValue = 0;

        while (prefixSize != 0) {
            if (prefixSize > 1) {
                nextValue = inp.nextLong();
            }
            prefixSum += prevValue;
            maxSum = Math.max(prefixSum, maxSum);
            if (prefixSum < 0) {
                prefixSum = 0;
            }

            prevValue = nextValue;
            prefixSize--;
        }

        System.out.println(maxSum);
        inp.close();
    }
}
