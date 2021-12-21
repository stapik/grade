package leetcode;

public class Median {

    public static void main(String[] args) {
        Median instance = new Median();
        System.out.println(instance.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, nIdx = 0, mIdx = 0;
        int[] concatenatedArray = new int[m + n];

        if (n == 0) {
            return median(nums2);
        }

        if (m == 0) {
            return median(nums1);
        }

        for (int i = 0; i < m + n; i++) {
            if (nums2.length > mIdx && (nums1.length == nIdx || nums1[nIdx] > nums2[mIdx])) {
                concatenatedArray[i] = nums2[mIdx];
                mIdx++;
            } else {
                concatenatedArray[i] = nums1[nIdx];
                nIdx++;
            }
        }

        return median(concatenatedArray);
    }

    private double median(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length % 2 == 0) {
            int idx = nums.length / 2;
            return (double) (nums[idx] + nums[idx - 1]) / 2;
        }

        return nums[(nums.length) / 2];
    }
}
