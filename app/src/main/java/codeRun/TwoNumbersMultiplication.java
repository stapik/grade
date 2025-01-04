package codeRun;

import java.io.*;

public class TwoNumbersMultiplication {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        long[] nums = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Long.parseLong(parts[i]);
        }

        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;

        for (long num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        if (max1 * max2 >= min1 * min2) {
            writer.write(max2 + " " + max1);
        } else {
            writer.write(min1 + " " + min2);
        }

        reader.close();
        writer.close();
    }
}
