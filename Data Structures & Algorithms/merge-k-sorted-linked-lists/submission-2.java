/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    private ListNode merge(ListNode sortedLeft, ListNode sortedRight) {
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        while (sortedLeft != null && sortedRight != null) {
            if (sortedLeft.val <= sortedRight.val) {
                curr.next = sortedLeft;
                sortedLeft = sortedLeft.next;
            } else {
                curr.next = sortedRight;
                sortedRight = sortedRight.next;
            }
            curr = curr.next;
        }
        if (sortedLeft != null) {
            curr.next = sortedLeft;
        }
        if (sortedRight != null) {
            curr.next = sortedRight;
        }
        return newHead.next;
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return lists[left];
        }
        int mid = left + (right-left)/2;
        ListNode sortedLeft = mergeLists(lists, left, mid);
        ListNode sortedRight = mergeLists(lists, mid+1, right);
        return merge(sortedLeft, sortedRight);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length-1);
    }
}
