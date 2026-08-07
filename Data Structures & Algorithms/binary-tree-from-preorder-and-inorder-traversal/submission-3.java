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
    private TreeNode buildTree(int[] preorder, int curr, Map<Integer, Integer> inorderIdxMap,
        int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[curr]);
        int mid = inorderIdxMap.get(preorder[curr]);
        node.left = buildTree(preorder, curr + 1, inorderIdxMap, left, mid-1);
        node.right = buildTree(preorder, curr + 1 + (mid - left), inorderIdxMap, mid+1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorderIdxMap, 0, inorder.length-1);
    }
}
