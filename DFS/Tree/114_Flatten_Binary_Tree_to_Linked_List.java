
/**
 * Name: Flatten Binary Tree to Linked List
 * Number: 114
 * Tag: DFS/d&c
 * Main Points: 
   (1) easy to think of 
   Each node's right child points to the next node of a pre-order traversal.
   So we can first flatten all the left subtree then right subtree
   then link left subtree to flattened right subtree  
 * Time Complexity: T(N) = 2T(N/2) + O(N/2) so, O(nlogn)
 * Space Complexity: O(logn)
   (2) then we can improve the first method, because in first method we spend
   some extra time in finding the last node of the left tree. So why don't we
   use a helper function that recursively return the last node of the constructed
   tree?
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

/**********************easy to think**********************/
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        
        TreeNode rightTemp = root.right;
        root.right = root.left;
        
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = rightTemp;
        
        root.left = null;   
        return;
    }
}

/***********************Improvement***********************/
class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    // helper returns the last node of the constricted tree
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;      
        
        //divide
        TreeNode leftLast = flattenHelper(root.left);
        TreeNode rightLast = flattenHelper(root.right);
        
        //construct
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        //return the lastNode to upper level
        if(rightLast != null) {
            return rightLast;
        }
        if(leftLast != null) {
            return leftLast;
        }
        return root;
    }
    
}