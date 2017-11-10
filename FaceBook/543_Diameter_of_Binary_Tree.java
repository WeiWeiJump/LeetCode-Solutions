/**
 * Name: Diameter of Binary Tree
 * Number: 543
 * Tag: DFS
 * Main Points:
   for every node, the longest path that pass this node is max left depth + max right depth.
   so in the helper function, our target is to find the maxDepth of each tree.
   we use max to record during the whole process, the longest path pass.
 * Time Complexity: O(n)
 * Space Complexity: ave:O(logn) w: O(n)
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //d&c
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //conquer
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
    
}