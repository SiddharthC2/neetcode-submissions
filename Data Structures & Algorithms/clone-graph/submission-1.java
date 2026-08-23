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
        return cloneDFS(node, new HashMap<>());        
    }

    private Node cloneDFS(
        final Node node,
        final Map<Node, Node> cloneMap
    ) {
        if (node == null) {
            return null;
        }
        Node currClone = cloneMap.get(node);
        if (currClone != null) {
            return currClone;
        }
        currClone = new Node(node.val);
        cloneMap.put(node, currClone);
        
        for (Node neighbor: node.neighbors) {
            currClone.neighbors.add(cloneDFS(neighbor, cloneMap));
        }
        return currClone;
    }
}