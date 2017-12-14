/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        preorderTraversal(root, null, 0);
        return maxLen;
    }
    private void preorderTraversal(TreeNode node, TreeNode parent, int length) {
        if (node == null) return;
        if (parent == null) {
            length++;
            maxLen = Math.max(maxLen, length);
        } else {
            if (node.val == parent.val + 1) {
                length++;
                maxLen = Math.max(maxLen, length);
            } else {
                length = 1;
            }
        }      
        preorderTraversal(node.left, node, length);
        preorderTraversal(node.right, node, length);
    }
}