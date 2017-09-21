/**
 * Name: Balanced Binary Tree
 * Number: 110
 * Tag: DFS
 * Main Points: 
   (1) post-order traversal
   use post-order traversal to recursively calculate height of the tree. 
   In this process, if Math.abs(left_height - right_height) > 1, then it's not balanced.
   (2) divide and conquer
   every level we need to know two information about the lower level:
   1. whether two subtrees are balanced
   2. the depth of each tree
   then we can decide whether this level is balanced.
   So we create a class to store these two information.
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

/***************************  post order  ***************************/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return DFSHelper(root) != -1;
    }
    //use the helper function to return the height of the tree
    //if the tree is not balanced, then return -1
    private int DFSHelper(TreeNode root) {
        if (root == null) return 0;
        int left = DFSHelper(root.left);
        if (left == -1) return -1;
        int right = DFSHelper(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
/************************* divide & conquer **************************/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return DFSHelper(root).isBalanced;
    }
    private ResultType DFSHelper(TreeNode root) {
        if (root == null) return new ResultType(true, 0);
        ResultType left = DFSHelper(root.left);
        ResultType right = DFSHelper(root.right);
        // subtree not balanced
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        //root not balanced
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}
class ResultType {
    public int depth;
    public boolean isBalanced;
    public ResultType(boolean isBalanced, int depth) {
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
}