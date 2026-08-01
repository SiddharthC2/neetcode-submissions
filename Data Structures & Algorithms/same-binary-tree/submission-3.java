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

    private List<TreeNode> getBFSNodeList(TreeNode node) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (node == null) {
            return nodeList;
        }

        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(node);
        nodeList.add(node);
        while (!bfsQueue.isEmpty()) {
            TreeNode currNode = bfsQueue.poll();
            if (currNode.left == null && currNode.right == null) {
                continue;
            }
            if (currNode.left != null) {
                bfsQueue.offer(currNode.left);
            }
            if (currNode.right != null) {
                bfsQueue.offer(currNode.right);
            }
            nodeList.add(currNode.left);
            nodeList.add(currNode.right);
        }
        return nodeList;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pNodeList = getBFSNodeList(p);
        List<TreeNode> qNodeList = getBFSNodeList(q);

        if (pNodeList.size() != qNodeList.size()) {
            return false;
        }

        for (int i=0; i<pNodeList.size(); i++) {
            TreeNode pNode = pNodeList.get(i);
            TreeNode qNode = qNodeList.get(i);
            if (pNode == null && qNode == null) {
                continue;
            } else if (pNode != null && qNode != null) {
                if (pNode.val != qNode.val) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
