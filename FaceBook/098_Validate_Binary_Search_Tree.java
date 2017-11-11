/**
 * Name: Validate Binary Search Tree
 * Number: 98
 * Tag: DFS/d&c
 * Main Points:
   a tree is validBST if its left subtree is validBST, right subtree is validBST
   and!!!
   max Node in left tree is less than root.val && min Node in right tree is larger than root.val
 * Time Complexity: O(n)
 * Space Complexity: worst O(n)
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
    public boolean isValidBST(TreeNode root) {
        return validHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean validHelper(TreeNode root, long leftMax, long rightMin) {
        if (root == null) return true;
        if (root.val <= rightMin ||root.val >= leftMax) {
            return false;
        }
        return validHelper(root.left, root.val, rightMin) && validHelper(root.right, leftMax, root.val);
    }
}