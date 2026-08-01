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

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> nodeDepthDiameterMap = new HashMap<>();
        nodeDepthDiameterMap.put(null, new int[]{0, 0});
        Deque<TreeNode> dfsStack = new ArrayDeque<>();
        dfsStack.push(root);

        while (!dfsStack.isEmpty()) {
            TreeNode curr = dfsStack.peek();

            if (curr.left != null && !nodeDepthDiameterMap.containsKey(curr.left)) {
                dfsStack.push(curr.left);
            } else if (curr.right != null && !nodeDepthDiameterMap.containsKey(curr.right)) {
                dfsStack.push(curr.right);
            } else {
                curr = dfsStack.pop();
                int[] leftDetails = nodeDepthDiameterMap.get(curr.left);
                int[] rightDetails = nodeDepthDiameterMap.get(curr.right);

                int[] currDetails = new int[2];
                currDetails[0] = Math.max(leftDetails[0], rightDetails[0])+1;
                int currMaxDiameter = Math.max(leftDetails[1], rightDetails[1]);
                currDetails[1] = Math.max(currMaxDiameter, leftDetails[0]+rightDetails[0]);

                nodeDepthDiameterMap.put(curr, currDetails);
            }
        }
        return nodeDepthDiameterMap.get(root)[1];
    }
}
