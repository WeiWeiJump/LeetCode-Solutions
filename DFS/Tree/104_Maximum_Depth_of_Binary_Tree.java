/**
 * Name: Maximum Depth of Binary Tree
 * Number: 104
 * Tag: DFS/Tree
 * Main Point: 
   Method1-traverse:
   on current level, what we should do is step left and increase depth, 
   then we try to step back, then step right, and also increase depth, 
   when you reach the end of a path, update maxDepth
   Method2-d&c:
   if left subtree is deeper, the max depth of the whole tree = max depth of its left tree + 1
   if right subtree is deeper, the max depth of the whole tree = max depth of its left tree + 1
 * Time Complexity: O(n) n is the number od nodes
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
/****************************** Traversal ******************************/
class Solution {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        DFSHelper(root, 0);
        return maxDepth;
    }
    private void DFSHelper(TreeNode root, int depth) {
        if (root == null) {
            //update maxDepth when you reach the end of a path
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        DFSHelper(root.left, depth + 1);
        DFSHelper(root.right,depth + 1);
    }
}
/**************************** divide and conquer ****************************/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}