package codeRun;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kline {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCover(mid, k, nums)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canCover(int length, int k, int[] nums) {
        int count = 1, start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > start + length) {
                count++;
                start = nums[i];
            }
            if (count > k) return false;
        }
        return true;
    }
}
