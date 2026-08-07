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

    private TreeNode buildTree(int[] preorder, int[] inorder,
        int curr, int left, int right) {
        if (left > right) {
            return null;
        }
        // System.out.println(curr+" "+left+" "+right);
        TreeNode node = new TreeNode(preorder[curr]);
        int mid = -1;
        for (int i=left; i<=right; i++) {
            if (inorder[i] == preorder[curr]) {
                mid = i;
                break;
            }
        }
        
        node.left = buildTree(preorder, inorder, curr+1, left, mid-1);
        node.right = buildTree(preorder, inorder, curr+1+(mid-left), mid+1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }
}
