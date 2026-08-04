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

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<Map.Entry<TreeNode, Integer>> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(Map.entry(root, Integer.MIN_VALUE));

        while (!bfsQueue.isEmpty()) {
            Map.Entry<TreeNode, Integer> currEntry = bfsQueue.poll();
            TreeNode currNode = currEntry.getKey();
            Integer currValue = currEntry.getValue();
            if (currNode.val >= currValue) {
                count++;
                currValue = currNode.val;
            }
            if (currNode.left != null) bfsQueue.offer(Map.entry(currNode.left, currValue));
            if (currNode.right != null) bfsQueue.offer(Map.entry(currNode.right, currValue));
        }

        return count;
    }
}
