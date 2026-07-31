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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> bfsNodes = new ArrayDeque<>();
        bfsNodes.offer(root);
        TreeNode curr, left, right;
        while (!bfsNodes.isEmpty()) {
            curr = bfsNodes.poll();
            left = curr.left;
            right = curr.right;
            if (left != null) {
                bfsNodes.offer(left);
            }
            if (right != null) {
                bfsNodes.offer(right);
            }
            curr.right = left;
            curr.left = right;
        }
        return root;
    }
}
