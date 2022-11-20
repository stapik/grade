package leetcode;

import java.util.Objects;

public class TwoSortedLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) && Objects.isNull(list2)) {
            return null;
        }
        if (Objects.isNull(list1)) {
            return list2;
        }

        if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode leftNode, rightNode, resultNode, lastResultNode;
        if (Integer.compare(list1.val, list2.val) == -1) {
            leftNode = list1;
            rightNode = list2;
        } else {
            leftNode = list2;
            rightNode = list1;
        }

        resultNode = new ListNode(leftNode.val);
        lastResultNode = resultNode;
        leftNode = leftNode.next;
        while (true) {
            if (Objects.nonNull(leftNode)) {
                if (leftNode.val <= rightNode.val) {
                    lastResultNode.next = leftNode;
                    leftNode = leftNode.next;
                } else {
                    lastResultNode.next = rightNode;
                    rightNode = rightNode.next;
                }
                lastResultNode = lastResultNode.next;
            }
            if (Objects.nonNull(rightNode) && Objects.isNull(leftNode)) {
                lastResultNode.next = rightNode;
                break;
            }
            if (Objects.isNull(rightNode)) {
                lastResultNode.next = leftNode;
                break;
            }
        }

        return resultNode;
    }
}
