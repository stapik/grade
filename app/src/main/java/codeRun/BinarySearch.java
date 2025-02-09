package codeRun;

import java.io.*;
import java.util.*;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken()), k = Integer.parseInt(tokenizer.nextToken());

        int[] nArr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i=0; i < n; i++) {
            nArr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(nArr);

        boolean[] result = new boolean[k];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < k; i++){
            result[i] = exists(Integer.parseInt(tokenizer.nextToken()), nArr);
        }

        StringJoiner sj = new StringJoiner("\n");
        for (boolean r: result){
            sj.add(r ? "YES" : "NO");
        }

        writer.write(sj.toString());
        reader.close();
        writer.close();
    }

    private static boolean exists(int value, int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (arr[m] < value) {
                left = m + 1;
            } else if (arr[m] > value) {
                right = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
