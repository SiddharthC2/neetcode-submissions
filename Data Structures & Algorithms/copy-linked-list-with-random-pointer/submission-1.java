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
    
    private Map<Node, Node> copyMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (copyMap.containsKey(head)) {
            return copyMap.get(head);
        }

        Node copyNode = new Node(head.val);
        copyMap.put(head, copyNode);
        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyMap.get(head.random);
        return copyNode;
    }
}
