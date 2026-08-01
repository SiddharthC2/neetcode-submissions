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

    private int getHeightOrNegOne(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int leftHeight = getHeightOrNegOne(curr.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeightOrNegOne(curr.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeightOrNegOne(root) == -1 ? false : true;
    }
}
