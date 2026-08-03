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
        if (root == null) {
            return levelOrderList;
        }
        TreeNode nullNode = new TreeNode();
        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(root);
        bfsQueue.offer(nullNode);
        List<Integer> currLevelList = new ArrayList<>();
        while (!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            if (curr == nullNode) {
                levelOrderList.add(currLevelList);
                if (bfsQueue.isEmpty()) break;
                currLevelList = new ArrayList<>();
                bfsQueue.offer(nullNode);
            } else {
                currLevelList.add(curr.val);
                if (curr.left != null) bfsQueue.offer(curr.left);
                if (curr.right != null) bfsQueue.offer(curr.right);
            }
        }
        return levelOrderList;
    }
}
