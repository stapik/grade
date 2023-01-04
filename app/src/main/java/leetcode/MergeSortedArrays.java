package leetcode;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIdx = 0, secondIdx = 0;
        int[] tempNums1 = Arrays.copyOf(nums1, m);

        for (int i = 0; i < m + n; i++) {
            if (firstIdx < m && secondIdx < n) {
                if(tempNums1[firstIdx] <= nums2[secondIdx]){
                    nums1[i]= tempNums1[firstIdx];
                    firstIdx++;
                } else {
                    nums1[i]= nums2[secondIdx];
                    secondIdx++;
                }
            } else if(firstIdx < m){
                nums1[i]= tempNums1[firstIdx];
                firstIdx++;
            } else if(secondIdx < n) {
                nums1[i]= nums2[secondIdx];
                secondIdx++;
            }
        }
    }
}
