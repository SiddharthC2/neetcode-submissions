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
    
    private ListNode reverseList(ListNode head) {
        ListNode curr=head, prev=null, next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head=new ListNode(), curr;
        curr=head;
        while (head1!=null && head2!=null) {
            curr.next=head1;
            head1=head1.next;
            curr = curr.next;
            curr.next=head2;
            head2=head2.next;
            curr = curr.next;
        }
        if (head1!=null) {
            curr.next=head1;
        }
        return head.next;
    }

    public void reorderList(ListNode head) {
        if (head.next==null || head.next.next==null) {
            return;
        }
        ListNode slow=head, fast=head, prev=null;
        while (fast!=null && fast.next!=null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2;
        if (fast!=null) {
            head2=slow.next;
            slow.next=null;
        } else {
            head2=slow;
            prev.next=null;
        }

        head2 = reverseList(head2);
        head = mergeTwoLists(head, head2);

        // ListNode curr = head;
        // while(curr!=null) {
        //     System.out.print(curr.val + "->");
        //     curr = curr.next;
        // }
    }
}
