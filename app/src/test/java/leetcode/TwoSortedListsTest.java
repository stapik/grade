package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoSortedListsTest {

    private final TwoSortedLists solution = new TwoSortedLists();

    @Test
    public void test1() {
        TwoSortedLists.ListNode result = solution.mergeTwoLists(new TwoSortedLists.ListNode(
                1, new TwoSortedLists.ListNode(3)
        ), new TwoSortedLists.ListNode(1, new TwoSortedLists.ListNode(4)));
        List<Integer> testValues = List.of(1, 1, 3, 4);
        for (Integer testValue : testValues) {
            System.out.println((int) testValue);
            assertEquals(result.val, (int) testValue);
            result = result.next;
        }
    }

    @Test
    public void test2() {
        TwoSortedLists.ListNode result = solution.mergeTwoLists(null, new TwoSortedLists.ListNode(0));
        List<Integer> testValues = List.of(0);
        for (Integer testValue : testValues) {
            assertEquals(result.val, (int) testValue);
            result = result.next;
        }
    }
}
