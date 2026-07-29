/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head, curr2;
        while (curr != null) {
            curr2 = new Node(curr.val);
            curr2.next = curr.next;
            curr.next = curr2;
            curr = curr2.next;
        }
        curr = head;
        while (curr != null) {
            curr2 = curr.next;
            curr2.random = curr.random == null ? null : curr.random.next;
            curr = curr2.next;
        }

        Node head2 = new Node(-1), curr3 = head2;
        curr = head;
        while (curr != null) {
            curr2 = curr.next;
            curr.next = curr2.next;
            curr = curr.next;

            curr3.next = curr2;
            curr3 = curr2;
        }
        return head2.next;
    }
}
