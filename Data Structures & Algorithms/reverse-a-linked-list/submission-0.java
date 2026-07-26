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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr=head, nextNode, prevHead=head;
        while(prevHead.next!=null) {
            nextNode = prevHead.next;
            prevHead.next = nextNode.next;
            nextNode.next = curr;
            curr = nextNode;
        }
        return curr;
    }
}
