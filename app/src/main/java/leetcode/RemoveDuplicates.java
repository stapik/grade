package leetcode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int cursor = 0;
        if (nums.length < 2) {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[cursor] != nums[i]) {
                cursor++;
                nums[cursor] = nums[i];
            }
        }
        return cursor + 1;
    }
}
