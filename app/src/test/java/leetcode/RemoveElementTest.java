package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class RemoveElementTest {

    private final RemoveElement solution = new RemoveElement();

    @Test
    public void test() {
        int[] arr1 = new int[]{1, 1, 2};
        int[] arrResult1 = Arrays.stream(arr1).limit(solution.removeElement(arr1, 1)).toArray();
        assertArrayEquals(arrResult1, new int[]{2});
        int[] arr2 = new int[]{3, 2, 2, 3};
        int[] arrResult2 = Arrays.stream(arr2).limit(solution.removeElement(arr2, 3)).toArray();
        assertArrayEquals(arrResult2, new int[]{2, 2});
    }
}
