package codeRun;

import java.io.*;

public class BinarySearchScore {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = Long.parseLong(reader.readLine()), b = Long.parseLong(reader.readLine()), c = Long.parseLong(reader.readLine());

        long left = 0, right = 10_000_000_000_000_000L, m, result = Long.MAX_VALUE;

        while (left <= right) {
            m = (left + right) / 2;
            if (lFour(a, b, c, m)) {
                left = m + 1;
            } else {
                result = m;
                right = m - 1;
            }
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }

    private static boolean lFour(long a, long b, long c, long d) {
        long totalSum = a * 2 + b * 3 + c * 4 + d * 5;
        long totalCount = a + b + c + d;
        return totalSum * 2 < totalCount * 7;
    }
}
