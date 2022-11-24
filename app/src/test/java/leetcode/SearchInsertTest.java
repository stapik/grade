package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInsertTest {

    private final SearchInsert solution = new SearchInsert();

    @Test
    public void testTrue() {
        assertEquals(solution.searchInsert(new int[]{1, 3, 5, 6}, 5), 2);
        assertEquals(solution.searchInsert(new int[]{1, 3, 5, 6}, 2), 1);
        assertEquals(solution.searchInsert(new int[]{1, 3, 5, 6}, 15), 4);
        assertEquals(solution.searchInsert(new int[]{1, 3, 5, 6}, 0), 0);
        assertEquals(solution.searchInsert(new int[]{1}, 2), 1);
    }
}
