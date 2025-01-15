package codeRun;

import java.io.*;

public class CarNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input1 = reader.readLine().split(" ");
        int carCount = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        String[] carNumbers = reader.readLine().split(" ");
        int[] nums = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            nums[i] = Integer.parseInt(carNumbers[i]);
        }

        int leftIdx = 0, rightIdx = 0, sum = 0, result = 0;
        while (rightIdx < carCount) {
            sum += nums[rightIdx];

            while (sum > k && leftIdx != rightIdx) {
                sum -= nums[leftIdx];
                leftIdx++;
            }

            if (sum == k) {
                result++;
            }

            rightIdx++;
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }
}
