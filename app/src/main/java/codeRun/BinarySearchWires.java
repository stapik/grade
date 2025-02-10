package codeRun;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BinarySearchWires {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken()), k = Integer.parseInt(tokenizer.nextToken());
        int[] lArr = new int[n];

        for (int i = 0; i < n; i++){
            lArr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(lArr);

        writer.write(String.valueOf(findCutCount(k, lArr)));

        reader.close();
        writer.close();
    }

    private static int findCutCount (int k, int[] lArr) {
        int left = 1, right = lArr[lArr.length - 1], l, resultLength = 0;

        while (left < right) {
            l = (left + right + 1) / 2;
            if (canCut(l, k, lArr)) {
                left = l;
                resultLength = l;
            } else {
                right = l - 1;
            }
        }
        return resultLength;
    }

    private static boolean canCut (int length, int k, int[] lArr) {
        int totalCuts = 0;
        for (int j : lArr) {
            totalCuts += j / length;
            if (totalCuts >= k) {
                return true;
            }
        }
        return false;
    }
}
