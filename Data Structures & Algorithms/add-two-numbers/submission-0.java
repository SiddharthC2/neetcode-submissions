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
        int sum = 0, carry = 0;
        while (curr1 != null && curr2 != null) {
            sum = curr1.val + curr2.val + carry;
            carry = sum/10;
            newCurr = new ListNode(sum%10);
            curr.next = newCurr;
            curr = newCurr;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            sum = curr1.val + carry;
            carry = sum/10;
            newCurr = new ListNode(sum%10);
            curr.next = newCurr;
            curr = newCurr;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            sum = curr2.val + carry;
            carry = sum/10;
            newCurr = new ListNode(sum%10);
            curr.next = newCurr;
            curr = newCurr;
            curr2 = curr2.next;
        }
        if (carry != 0) {
            newCurr = new ListNode(carry);
            curr.next = newCurr;
            curr = newCurr;
        }

        return l3.next;
    }
}
