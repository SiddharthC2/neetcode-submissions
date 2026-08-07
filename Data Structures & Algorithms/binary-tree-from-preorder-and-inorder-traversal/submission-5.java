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
    private TreeNode buildTree(int[] preorder, int[] curr, Map<Integer, Integer> inorderIdxMap,
        int left, int right) {
        if (left > right) {
            return null;
        }
        int currVal = curr[0]++;
        TreeNode node = new TreeNode(preorder[currVal]);
        int mid = inorderIdxMap.get(preorder[currVal]);
        node.left = buildTree(preorder, curr, inorderIdxMap, left, mid-1);
        node.right = buildTree(preorder, curr, inorderIdxMap, mid+1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return buildTree(preorder, new int[] {0}, inorderIdxMap, 0, inorder.length-1);
    }
}
