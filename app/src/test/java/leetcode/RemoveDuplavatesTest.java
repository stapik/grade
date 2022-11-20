package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplavatesTest {

    private final RemoveDuplicates solution = new RemoveDuplicates();

    @Test
    public void test() {
        assertEquals(solution.removeDuplicates(new int[]{1, 1, 2}), 2);
        assertEquals(solution.removeDuplicates(new int[]{1, 1, 2, 2}), 2);
        assertEquals(solution.removeDuplicates(new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5}), 5);
    }
}
