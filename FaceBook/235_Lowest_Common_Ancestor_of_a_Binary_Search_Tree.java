/**
 * Name: Lowest Common Ancestor of a Binary Search Tree
 * Number: 235
 * Tag: BST
 * Main Points: compare range
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null || q == null) return p == null ? q : p;
        
        TreeNode low, high;
        if (p.val > q.val) {
            low = q; high = p;
        } else {
            low = p; high = q;
        }
        
        while (root != null) {
            if (root == low || root == high) return root;
            if (root.val > high.val) {
                root = root.left;
            } else if (root.val < low.val){
                root = root.right;
            } else {
                return root;
            }
        }
        return root;      
    }
}