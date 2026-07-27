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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null, curr = null;
        while (list1!=null && list2!=null) {
            if (list1.val <= list2.val) {
                if (curr == null) {
                    mergedList = list1;
                } else {
                    curr.next = list1;
                }
                curr = list1;
                list1 = list1.next;
            }
            else {
                if (curr == null) {
                    mergedList = list2;
                } else {
                    curr.next = list2;
                }
                curr = list2;
                list2 = list2.next;
            }
        }
        if (list1!=null) {
            if (curr == null) {
                mergedList = list1;
            } else {
                curr.next = list1;
            }
        }
        if (list2!=null) {
            if (curr == null) {
                mergedList = list2;
            } else {
                curr.next = list2;
            }
        }
        return mergedList;
    }
}