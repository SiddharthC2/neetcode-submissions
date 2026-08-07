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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder treeStrBldr = new StringBuilder();
        TreeNode nullNode = new TreeNode(), leftNode, rightNode;
        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(root);
        boolean allNulls = false;

        while (!bfsQueue.isEmpty() && !allNulls) {
            allNulls = true;
            for (int i=bfsQueue.size()-1; i>=0; i--) {
                TreeNode currNode = bfsQueue.poll();
                leftNode = nullNode;
                rightNode = nullNode;
                if (currNode == nullNode) {
                    treeStrBldr.append("null,");
                    continue;
                } else {
                    treeStrBldr.append(String.valueOf(currNode.val));
                    treeStrBldr.append(",");
                    if (currNode.left != null) {
                        allNulls = false;
                        leftNode = currNode.left;
                    }
                    if (currNode.right != null) {
                        allNulls = false;
                        rightNode = currNode.right;
                    }
                }
                bfsQueue.offer(leftNode);
                bfsQueue.offer(rightNode);
            }
        }
        // System.out.println(treeStrBldr.toString());
        return treeStrBldr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (isNullStr(data)) {
            return null;
        }
        // 1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,null,null
        // 1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3
        Map<Integer, TreeNode> valNodeMap = new HashMap<>();
        
        String[] splitArr = data.split(",");
        for (int i=0; i<Math.min(30, splitArr.length); i++) {
            System.out.print(splitArr[i]+",");
        }
        System.out.println();

        TreeNode root = new TreeNode(Integer.parseInt(splitArr[0]));
        TreeNode currNode, left, right;
        valNodeMap.put(0, root);
        int curr=0, next=1;
        while (curr < next && next < splitArr.length) {
            if (!isNullStr(splitArr[curr])) {
                currNode = valNodeMap.get(curr);
                if (!isNullStr(splitArr[next])) {
                    left = new TreeNode(Integer.parseInt(splitArr[next]));
                    valNodeMap.put(next, left);
                    currNode.left = left;
                }
                next++;
                if (!isNullStr(splitArr[next])) {
                    right = new TreeNode(Integer.parseInt(splitArr[next]));
                    valNodeMap.put(next, right);
                    currNode.right = right;
                }
                next++;
            }
            curr++;
        }

        return root;
    }

    private boolean isNullStr(String input) {
        return "null".equals(input);
    }
}
