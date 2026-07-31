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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        bfsQ.offer(null);
        int depth = 0;
        while (!bfsQ.isEmpty()) {
            TreeNode curr = bfsQ.poll();
            if (curr == null) {
                depth++;
                if (!bfsQ.isEmpty()) bfsQ.offer(null);
            } else {
                if (curr.left != null) bfsQ.offer(curr.left);
                if (curr.right != null) bfsQ.offer(curr.right);
            }
        }

        return depth;
    }
}