/**
 * Name: House Robber III
 * Number: 337
 * Tag: d&c
 * Main Points: 
   dfs all the nodes of the tree, each node return two number, int[] num, 
   num[0] is the max value while rob this node, num[1] is max value while not rob this value.
   Current node return value only depend on its children's value. 
 * Time Complexity: O(n);
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
/*****************************Normal Method******************************/
public int rob(TreeNode root) {
    if (root == null) return 0;   
    int val = 0;   
    if (root.left != null) {
        val += rob(root.left.left) + rob(root.left.right);
    }    
    if (root.right != null) {
        val += rob(root.right.left) + rob(root.right.right);
    }    
    return Math.max(val + root.val, rob(root.left) + rob(root.right));
}

/****************************Improvement******************************/
class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] robThisRoom = robHelper(root);
        return Math.max(robThisRoom[0], robThisRoom[1]);
    }
    private int[] robHelper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] robThisRoom = new int[2];
        robThisRoom[1] = left[0] + right[0] + root.val;
        robThisRoom[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return robThisRoom;
    }
}