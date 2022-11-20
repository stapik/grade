package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaTest {

    private final MaxArea solution = new MaxArea();

    @Test
    public void test() {
        assertEquals(solution.maxArea(new int[]{1, 1, 2}), 2);
        assertEquals(solution.maxArea(new int[]{5, 40, 20, 5}), 20);
        assertEquals(solution.maxArea(new int[]{1, 1}), 1);
        assertEquals(solution.maxArea(new int[]{1, 2, 4, 3}), 4);
        assertEquals(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        assertEquals(solution.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}), 17);
        assertEquals(solution.maxArea(new int[]{1, 1, 5, 25, 24, 5}), 24);
        assertEquals(solution.maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}), 24);
    }
}
