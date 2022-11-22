package leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int target) {
        int lastIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[lastIdx] = nums[i];
                lastIdx++;
            }
        }
        return lastIdx;
    }
}
