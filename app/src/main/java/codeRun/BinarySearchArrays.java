package codeRun;

import java.io.*;
import java.util.StringJoiner;

public class BinarySearchArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]), k = Integer.parseInt(parts[1]);
        parts = reader.readLine().split(" ");
        int[] numsN = new int[n];
        for (int i = 0; i < n; i++) {
            numsN[i] = Integer.parseInt(parts[i]);
        }

        parts = reader.readLine().split(" ");
        int[] numsK = new int[k];
        for (int i = 0; i < k; i++) {
            numsK[i] = Integer.parseInt(parts[i]);
        }

        StringJoiner sj = new StringJoiner("\n");

        for(int i = 0; i < k; i++) {
            int numK = numsK[i], numN;
            int left = 0, right = n - 1, m;
            int closestNum = numsN[0];
            while (left <= right) {
                m = (left + right) / 2;
                numN = numsN[m];
                if (numN < numK) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
                if (Math.abs(numN - numK) < Math.abs(closestNum - numK) || (Math.abs(numN - numK) == Math.abs(closestNum - numK) && numN < closestNum)) {
                    closestNum = numN;
                }
            }
            sj.add(String.valueOf(closestNum));
        }

        writer.write(sj.toString());

        reader.close();
        writer.close();
    }
}
