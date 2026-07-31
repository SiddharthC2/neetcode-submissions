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
        Deque<TreeNode> dfsStack = new ArrayDeque<>();
        dfsStack.push(root);
        TreeNode curr, left, right;
        while (!dfsStack.isEmpty()) {
            curr = dfsStack.pop();
            left = curr.left;
            right = curr.right;
            if (left != null) {
                dfsStack.push(left);
            }
            if (right != null) {
                dfsStack.push(right);
            }
            curr.right = left;
            curr.left = right;
        }
        return root;
    }
}
