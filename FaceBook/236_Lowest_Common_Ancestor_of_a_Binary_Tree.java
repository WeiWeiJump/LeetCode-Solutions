/**
 * Name: Lowest Common Ancestor of a Binary Tree
 * Number: 236
 * Tag: d & c
 * Main Points: search lowestCommonAncestor in left subtree and right subtree
   if find in both subtrees, then root is the LCA
   if only find in left subtree, return that node
   if only find in right subtree, return that node
   if didn't find in both subtrees, return null  
   actually we are doing a postorder traversal
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        } 
        //divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //conquer
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}