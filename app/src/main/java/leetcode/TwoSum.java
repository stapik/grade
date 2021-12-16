package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum instance = new TwoSum();
        System.out.println(Arrays.toString(instance.twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int sum;
        List<Integer[]> numList = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            numList.add(new Integer[]{i, nums[i]});
        }

        numList.sort(Comparator.comparing(o -> o[1]));

        parent:
        for (int j = 0; j < numList.size() - 1; j++) {
            for (int k = j + 1; k < numList.size(); k++) {
                sum = numList.get(j)[1] + numList.get(k)[1];
                if (sum == target) {
                    result = new int[]{numList.get(j)[0], numList.get(k)[0]};
                    break parent;
                }
                if (sum > target) {
                    break;
                }
            }
        }

        return result;
    }
}
