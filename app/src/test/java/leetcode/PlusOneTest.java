package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PlusOneTest {

    private final PlusOne solution = new PlusOne();

    @Test
    public void test() {
        assertArrayEquals(solution.plusOne(new int[]{1, 2, 3}), new int[]{1, 2, 4});
        assertArrayEquals(solution.plusOne(new int[]{4, 3, 2, 1}),new int[]{4, 3, 2, 2});
        assertArrayEquals(solution.plusOne(new int[]{9}), new int[]{1, 0});
    }
}
