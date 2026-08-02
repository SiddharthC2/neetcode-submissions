/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private void getBSTVisitedNodes(
        TreeNode node,
        TreeNode target,
        List<TreeNode> visitedNodes) {
        if (node == null) {
            return;
        }
        if (node == target) {
            visitedNodes.add(node);
            return;
        }
        visitedNodes.add(node);
        if (node.val >= target.val) {
            getBSTVisitedNodes(node.left, target, visitedNodes);
        } else {
            getBSTVisitedNodes(node.right, target, visitedNodes);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> visitedNodesP = new ArrayList<>();
        getBSTVisitedNodes(root, p, visitedNodesP);

        List<TreeNode> visitedNodesQ = new ArrayList<>();
        getBSTVisitedNodes(root, q, visitedNodesQ);

        List<TreeNode> temp;
        if (visitedNodesP.size() > visitedNodesQ.size()) {
            temp = visitedNodesQ;
            visitedNodesQ = visitedNodesP;
            visitedNodesP = temp;
        }

        int i = 0, n = visitedNodesP.size();
        for (i=0; i<n; i++) {
            if (visitedNodesP.get(i) != visitedNodesQ.get(i)) {
                break;
            }
        }
        return visitedNodesP.get(i-1);
    }
}
