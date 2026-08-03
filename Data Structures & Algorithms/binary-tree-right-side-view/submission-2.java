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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        dfsWithLevel(root, 0, rightViewList);
        return rightViewList;
    }

    private void dfsWithLevel(
        TreeNode node, 
        int level,
        List<Integer> rightViewList) {
            if (node == null) {
                return;
            }
            if (level == rightViewList.size()) {
                rightViewList.add(node.val);
            }
            dfsWithLevel(node.right, level+1, rightViewList);
            dfsWithLevel(node.left, level+1, rightViewList);
    }
}
