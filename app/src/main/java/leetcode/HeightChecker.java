package leetcode;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        int count = 0;
        Arrays.sort(sortedNums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i]) {
                count++;
            }
        }
        return count;
    }
}
