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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<Object[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(new Object[] {root, Long.MIN_VALUE, Long.MAX_VALUE});

        while (!bfsQueue.isEmpty()) {
            Object[] currObj = bfsQueue.poll();
            TreeNode currNode = (TreeNode) currObj[0];
            long min = (long) currObj[1];
            long max = (long) currObj[2];
            long currVal = (long) currNode.val;

            if (currVal <= min || currVal >= max) {
                return false;
            }
            if (currNode.left != null) bfsQueue.offer(new Object[]{currNode.left, min, currVal});
            if (currNode.right != null) bfsQueue.offer(new Object[]{currNode.right, currVal, max});
        }
        return true;
    }

}
