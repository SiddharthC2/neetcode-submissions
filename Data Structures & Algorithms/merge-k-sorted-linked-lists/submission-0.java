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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode sortedHead = new ListNode(-1);
        ListNode curr = sortedHead;
        ListNode minNode;
        int minIdx;
        while (true) {
            minIdx = -1;
            for (int i=0; i<lists.length; i++) {
                if (lists[i] != null) {
                    if (minIdx == -1 || lists[minIdx].val > lists[i].val) {
                        minIdx = i;
                    }
                }
            }
            if (minIdx == -1) {
                break;
            }
            minNode = lists[minIdx];
            curr.next = minNode;
            curr = curr.next;
            lists[minIdx] = lists[minIdx].next;           
        }
        return sortedHead.next;

    }
}
