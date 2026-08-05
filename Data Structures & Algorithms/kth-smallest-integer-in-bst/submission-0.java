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

    private void dfsInorder(TreeNode node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }
        dfsInorder(node.left, inorderList);
        inorderList.add(node.val);
        dfsInorder(node.right, inorderList);        
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        dfsInorder(root, inorderList);
        return inorderList.get(k-1);        
    }
}
