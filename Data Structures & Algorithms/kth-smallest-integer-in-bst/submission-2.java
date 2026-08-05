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

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> dfsStack = new ArrayDeque<>();
        TreeNode curr = root;

        while (!dfsStack.isEmpty() || curr != null) {
            while (curr != null) {
                dfsStack.push(curr);
                curr = curr.left;
            }
            curr = dfsStack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }

}
