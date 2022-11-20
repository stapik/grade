package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeSumClosestTest {

    private final ThreeSumClosest solution = new ThreeSumClosest();

    @Test
    public void test() {
        assertEquals(solution.threeSumClosest(new int[]{-1,2,1,-4}, 2), 2);
        assertEquals(solution.threeSumClosest(new int[]{-1,2,1,1,-5,3,3}, 3), 3);
    }
}
