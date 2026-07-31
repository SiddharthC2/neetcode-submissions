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

    private ListNode reverseList(ListNode curr, ListNode endNode) {
        if (curr == endNode) {
            return curr;
        }
        ListNode prev = curr;
        curr = reverseList(curr.next, endNode);
        curr.next = prev;
        return prev;
    }

    private void reverseListGrp(ListNode startNode, ListNode endNode) {
        reverseList(startNode, endNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prevGrpTail, currGrpHead, nextGrpHead, curr;
        prevGrpTail = newHead;
        currGrpHead = newHead.next;
        curr = currGrpHead;
        int currGrpCount = 1;
        while (curr != null) {
            if (currGrpCount == k) {
                nextGrpHead = curr.next;
                reverseListGrp(currGrpHead, curr);
                prevGrpTail.next = curr;
                prevGrpTail = currGrpHead;
                currGrpHead.next = nextGrpHead;
                currGrpHead = nextGrpHead;
                curr = currGrpHead;
                currGrpCount = 1;
            } else {
                curr = curr.next;
                currGrpCount++;
            }
        }
        return newHead.next;
    }
}
