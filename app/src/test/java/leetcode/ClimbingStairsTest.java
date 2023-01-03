package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairsTest {

    private final ClimbingStairs solution = new ClimbingStairs();

    @Test
    public void test() {
        assertEquals(solution.climbStairs(1), 1);
        assertEquals(solution.climbStairs(2), 2);
        assertEquals(solution.climbStairs(3), 3);
    }
}
