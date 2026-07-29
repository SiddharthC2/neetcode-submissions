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
        Map<Node, Node> copyMap = new HashMap<>();
        copyMap.put(null, null);
        Node curr = head, curr2;
        while (curr != null) {
            curr2 = new Node(curr.val);
            copyMap.put(curr, curr2);
            curr = curr.next;
        }
        
        Node copyHead = new Node(-1), curr3 = copyHead;
        curr = head;
        while (curr != null) {
            curr2 = copyMap.get(curr);
            curr2.next = copyMap.get(curr.next);
            curr2.random = copyMap.get(curr.random);
            curr3.next = curr2;
            curr3 = curr2;
            curr = curr.next;
        }
        return copyHead.next;
    }
}
