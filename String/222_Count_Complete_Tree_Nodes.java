/**
 * Name: Count Complete Tree Node
 * Number: 222
 * Tag: Binary Tree / Recursion
 * Main Point: we know that when a tree is full, its nodes amount = 2 ^ (height) - 1;
   first we calculate the height of the tree, left subtree and right subtree.
   case1: if height(right subtree) = height(tree) - 1, it indicates that left subtree is full
          so number of nodes = left subtree's nodes (full) + right subtree's nodes(recursion).
   case2: if height(right_subtree) = height(tree) - 2, it indicates that right subtree is full
          so number of nodes = left subtree's nodes (recursion)+ right subtree's nodes(full).
 * Time Comlexity: O(log(n)^2);
   Since I halve the tree in every recursive step, I have O(log(n)) steps. 
   Finding a height costs O(log(n)). So overall O(log(n)^2).
 * Space Complexity: taking frame space into account O(log(n)^2)
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int heightOfRoot = getHeight(root);
        int heightOfLeft = heightOfRoot - 1;
        int heightOfRight = getHeight(root.right);
        
        // left subtree is full
        int leftNodes = 0, rightNodes = 0;
        if (heightOfRight == heightOfRoot - 1) {
            leftNodes = (1 << heightOfLeft) - 1;
            rightNodes = countNodes(root.right); 
        } else {
            leftNodes = countNodes(root.left);
            rightNodes = (1 << heightOfRight) - 1;
        }
        int count = leftNodes + rightNodes + 1;
        return count;
    }
    private int getHeight(TreeNode root) {
        return root == null ? 0 : 1 + getHeight(root.left);
    }
}