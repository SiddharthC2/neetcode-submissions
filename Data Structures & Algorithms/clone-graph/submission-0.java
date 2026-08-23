/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneBFS(node);        
    }

    private Node cloneBFS(
        final Node node
    ) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> cloneMap = new HashMap<>();
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);

        Queue<Node> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(node);

        Node curr, currClone, newNode;
        while (!bfsQueue.isEmpty()) {
            curr = bfsQueue.poll();
            currClone = cloneMap.get(curr);
            for (Node neighbor: curr.neighbors) {
                newNode = cloneMap.get(neighbor);
                if (newNode == null) {
                    newNode = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNode);
                    bfsQueue.offer(neighbor);
                }
                currClone.neighbors.add(newNode);
            }
        }
        return cloneNode;
    }
}