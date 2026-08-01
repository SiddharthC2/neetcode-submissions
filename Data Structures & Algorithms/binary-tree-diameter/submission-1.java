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

    private static class NodeDepthDetails {
        int maxDepth;
        int currDiameter;

        NodeDepthDetails() {

        }
        
        NodeDepthDetails(int maxDepth, int currDiameter) {
            this.maxDepth = maxDepth;
            this.currDiameter = currDiameter;
        }
    }

    private NodeDepthDetails dfsDetermineDiameter(TreeNode node) {
        if (node == null) {
            return new NodeDepthDetails(0, 0);
        }
        NodeDepthDetails leftDepthDetails = dfsDetermineDiameter(node.left);
        NodeDepthDetails rightDepthDetails = dfsDetermineDiameter(node.right);

        NodeDepthDetails nodeDepthDetails = new NodeDepthDetails();
        nodeDepthDetails.maxDepth = Math.max(
                leftDepthDetails.maxDepth,
                rightDepthDetails.maxDepth
            ) + 1;
        nodeDepthDetails.currDiameter = Math.max(
                leftDepthDetails.currDiameter,
                rightDepthDetails.currDiameter
            );
        nodeDepthDetails.currDiameter = Math.max(
                nodeDepthDetails.currDiameter,
                (leftDepthDetails.maxDepth + rightDepthDetails.maxDepth)
            );
        return nodeDepthDetails;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dfsDetermineDiameter(root).currDiameter;
    }
}
