package leetcode;

public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0, leftIdx = 0, rightIdx = height.length - 1;
        while (leftIdx != rightIdx) {
            maxArea = Math.max(Math.min(height[leftIdx], height[rightIdx]) * (rightIdx - leftIdx), maxArea);
            if (height[leftIdx] < height[rightIdx]) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return maxArea;
    }
}
