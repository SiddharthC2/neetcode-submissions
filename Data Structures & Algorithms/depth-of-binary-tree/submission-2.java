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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> currPair = stack.pop();
            TreeNode curr = currPair.getKey();
            Integer currDepth = currPair.getValue();

            if (curr != null) {
                depth = Math.max(depth, currDepth);
                stack.push(new Pair<>(curr.left, currDepth+1));
                stack.push(new Pair<>(curr.right, currDepth+1));
            }

        }

        return depth;
    }
}