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
        ListNode newHead = new ListNode(0, head), curr = newHead;
        while (headStart != null) {
            curr = curr.next;
            headStart = headStart.next;
        }
        curr.next = curr.next.next;
        return newHead.next;
    }
}
