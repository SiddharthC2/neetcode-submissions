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

    private void dfsInorder(TreeNode node, int[] pair) {
        if (node == null) {
            return;
        }
        dfsInorder(node.left, pair);
        if (pair[0] == 0) return;
        pair[0]--;
        if (pair[0] == 0) {
            pair[1] = node.val;
            return;
        }
        dfsInorder(node.right, pair);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] pair = new int[2];
        pair[0] = k;
        dfsInorder(root, pair);
        return pair[1];      
    }
}
