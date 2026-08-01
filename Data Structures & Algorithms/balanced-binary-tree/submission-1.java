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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        nodeHeightMap.put(null, 0);
        Deque<TreeNode> dfsStack = new ArrayDeque<>();
        dfsStack.push(root);
        while (!dfsStack.isEmpty()) {
            TreeNode curr = dfsStack.peek();
            if(curr.left != null && !nodeHeightMap.containsKey(curr.left)) {
                dfsStack.push(curr.left);
            } else if (curr.right != null && !nodeHeightMap.containsKey(curr.right)) {
                dfsStack.push(curr.right);
            } else {
                curr = dfsStack.pop();
                int leftHeight = nodeHeightMap.get(curr.left);
                int rightHeight = nodeHeightMap.get(curr.right);

                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return false;
                }
                nodeHeightMap.put(curr, Math.max(leftHeight, rightHeight)+1);
            }
        }
        return true;
    }

}
