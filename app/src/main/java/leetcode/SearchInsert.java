package leetcode;

import java.util.function.Predicate;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return lBinSearch(0, nums.length, i -> nums[i] >= target);
    }

    private static Integer lBinSearch(int l, int r, Predicate<Integer> checker) {
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (checker.test(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
