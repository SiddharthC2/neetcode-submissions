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

    private int maxPathSum(TreeNode node, int[] globalMax) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxPathSum(node.left, globalMax);
        int rightSum = maxPathSum(node.right, globalMax);
        
        int currMax = node.val;
        currMax = Math.max(currMax, node.val+leftSum);
        currMax = Math.max(currMax, node.val+rightSum);

        globalMax[0] = Math.max(globalMax[0], Math.max(currMax, node.val+leftSum+rightSum));
        
        return currMax;
    }

    public int maxPathSum(TreeNode root) {
        int[] globalMax = new int[]{ Integer.MIN_VALUE };
        maxPathSum(root, globalMax);
        return globalMax[0];
        
    }
}
