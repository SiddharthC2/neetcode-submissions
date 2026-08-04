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

    private void findGoodNodes(TreeNode node, int currMax, int[] count) {
        if (node == null) {
            return;
        }
        if (node.val >= currMax) {
            count[0]++;
            currMax = node.val;
        }
        findGoodNodes(node.left, currMax, count);
        findGoodNodes(node.right, currMax, count);
    }

    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        findGoodNodes(root, Integer.MIN_VALUE, count);
        return count[0];
    }
}
