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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        if (root == null) {
            return rightViewList;
        }
        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(root);
        
        while (!bfsQueue.isEmpty()) {
            for (int i=bfsQueue.size()-1; i>=0; i--) {
                TreeNode curr = bfsQueue.poll();
                if (i == 0) {
                    rightViewList.add(curr.val);
                }
                if (curr.left != null) bfsQueue.offer(curr.left);
                if (curr.right != null) bfsQueue.offer(curr.right);
            }
        }
        return rightViewList;
    }
}
