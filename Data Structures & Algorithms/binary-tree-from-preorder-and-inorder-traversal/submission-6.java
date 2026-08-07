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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, new int[] {0}, new int[] {0}, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(
        int[] preorder,
        int[] inorder,
        int[] preIdx,
        int[] inIdx,
        int limit
    ) {
        if (preIdx[0] == preorder.length) {
            return null;
        }
        if (inorder[inIdx[0]] == limit) {
            inIdx[0]++;
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIdx[0]++]);
        node.left = buildTree(preorder, inorder, preIdx, inIdx, node.val);
        node.right = buildTree(preorder, inorder, preIdx, inIdx, limit);
        return node;
    }
}
