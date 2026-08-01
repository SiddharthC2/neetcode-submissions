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

    private int dfsGetMaxHeight(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfsGetMaxHeight(node.left, maxDiameter);
        int rightHeight = dfsGetMaxHeight(node.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], (leftHeight+rightHeight));
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        dfsGetMaxHeight(root, maxDiameter);
        return maxDiameter[0];
    }
}
