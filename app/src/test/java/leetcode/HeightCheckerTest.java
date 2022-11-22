package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeightCheckerTest {

    private final HeightChecker solution = new HeightChecker();

    @Test
    public void test() {
        assertEquals(solution.heightChecker(new int[]{1, 3, 2, 4}), 2);
        assertEquals(solution.heightChecker(new int[]{2, 1}), 2);
        assertEquals(solution.heightChecker(new int[]{}), 0);
    }
}
