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

    // null - N
    // separator - |
    // serializeBTree - Inorder traversal will not work!
    private String serializeBTree(TreeNode root) {
        if (root == null) {
            return "|N";
        }
        return "|" + String.valueOf(root.val)
             + serializeBTree(root.left)
             + serializeBTree(root.right); 
    }

    // KMP alogrithm
    private boolean containsSubstring(String original, String pattern) {
        int n = original.length(), k = pattern.length();
        if (n < k) {
            return false;
        }
        int[] suffixPrefixIdxArr = getKMPSuffixPrefixIdxArr(pattern);
        int i = 0, j = 0;
        while (i < n) {
            if (original.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = suffixPrefixIdxArr[j-1];
                }
            }

            if (j == k) {
                return true;
            }
        }
        return false;
    }

    private int[] getKMPSuffixPrefixIdxArr(String pattern) {
        int k = pattern.length();
        int[] suffixPrefixIdxArr = new int[k];
        suffixPrefixIdxArr[0] = 0;
        int i = 1, j = 0;
        while (i < k) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                suffixPrefixIdxArr[i] = ++j;
                i++;
            } else {
                if (j == 0) {
                    suffixPrefixIdxArr[i] = 0;
                    i++;
                } else {
                    j = suffixPrefixIdxArr[j-1];
                }
            }
        }
        return suffixPrefixIdxArr;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootString = serializeBTree(root);
        String subRootString = serializeBTree(subRoot);
        return containsSubstring(rootString, subRootString);
    }
}
