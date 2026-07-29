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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode(), curr = l3, newCurr, curr1 = l1, curr2 = l2;
        int sum = 0, carry = 0, val1, val2;
        while (curr1 != null || curr2 != null || carry != 0) {
            val1 = 0;
            val2 = 0;
            if (curr1 != null) {
                val1 = curr1.val;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                val2 = curr2.val;
                curr2 = curr2.next;
            }
            sum = val1 + val2 + carry;
            carry = sum/10;
            newCurr = new ListNode(sum%10);
            curr.next = newCurr;
            curr = newCurr;
        }

        return l3.next;
    }
}
