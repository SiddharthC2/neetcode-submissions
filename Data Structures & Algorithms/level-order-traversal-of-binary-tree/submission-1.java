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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        dfsWithLevel(root, 0, levelOrderList);
        return levelOrderList;
    }
    
    private void dfsWithLevel(TreeNode node, int level, List<List<Integer>> levelOrderList) {
        if (node == null) {
            return;
        }
        if (level == levelOrderList.size()) {
            levelOrderList.add(new ArrayList<>());
        }
        levelOrderList.get(level).add(node.val);
        dfsWithLevel(node.left, level+1, levelOrderList);
        dfsWithLevel(node.right, level+1, levelOrderList);
    }
}
