/**
 * Name: Subtree of Another Tree
 * Number: 527
 * Tag: DFS
 * Main Points:
   t is s's subtree in 3 cases:
   1. t is the same as s
   2. t is s's left subtree's subtree
   3. t is s's right subtree's subtree
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t != null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}