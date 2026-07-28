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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int steps = n;
        ListNode headStart = head;
        while (steps != 0) {
            headStart = headStart.next;
            steps--;
        }
        ListNode newHead = new ListNode(), prev = newHead, curr = head;
        newHead.next = head;
        while (headStart != null) {
            prev = curr;
            curr = curr.next;
            headStart = headStart.next;
        }
        prev.next = curr.next;
        curr.next = null;
        curr = null;
        return newHead.next;
    }
}
