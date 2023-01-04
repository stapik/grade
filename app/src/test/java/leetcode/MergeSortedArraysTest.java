package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArraysTest {

    private final MergeSortedArrays solution = new MergeSortedArrays();

    @Test
    public void test() {
        int[] test = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(test, 3, new int[]{2, 5, 6}, 3);
        Assert.assertArrayEquals(test, new int[]{1, 2, 2, 3, 5, 6});

        test = new int[]{1};
        solution.merge(test, 1, new int[]{}, 0);
        Assert.assertArrayEquals(test, new int[]{1});
    }
}
