package x5;

import java.util.*;

public class Blogger {

    public static int closestSum(List<Integer> nums, int target) {
        Collections.sort(nums);
        int sum;
        NavigableMap<Integer, Integer> result = new TreeMap<>();

        if (nums.get(nums.size() - 1) <= target) {
            return nums.stream().skip(nums.size() - 3).reduce(Integer::sum).orElse(0);
        }

        if (nums.get(0) >= target) {
            return nums.stream().limit(3).reduce(Integer::sum).orElse(0);
        }

        for (int i1 = 0; i1 < nums.size() - 2; i1++) {
            for (int i2 = i1 + 1; i2 < nums.size() - 1; i2++) {
                for (int i3 = i2 + 1; i3 < nums.size(); i3++) {
                    sum = nums.get(i1) + nums.get(i2) + nums.get(i3);
                    result.put(Math.abs(sum - target), sum);
                }
            }
        }

        return result.firstEntry().getValue();
    }

}
