package leetcode;

import java.util.Arrays;

public class MinDiffWindowK {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1 ,7};
        int k = 2;
        System.out.println("Good 2: " + minimumDifference(nums, k));
    }


    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        if (nums.length < k) return 0;

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int left = 0; left <= nums.length - k; left++) {
            minDiff = Math.min(minDiff, nums[left + k - 1] - nums[left]);
        }

        return minDiff;
    }
}
