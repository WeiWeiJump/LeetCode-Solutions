/**
 * Name: Minimum Depth of Binary Tree
 * Number: 111
 * Tag: DFS
 * Main Point: Attention we can't return Math.min(left, right) + 1, if only one of root's child is null.
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
**/
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(left, right) + 1;
        }
        if (root.left != null) {
            return left + 1;
        }
        if (root.right != null) {
            return right + 1;
        }
        return 1;
    }
}