/**
 * Name: Inorder Successor in BST
 * Number: 285
 * Tag: DFS
 * Main Points: 
   successor: find the substitue for node p, which is just larger than p.val
   first, we search from the root downside to find the node N that starts to be larger than p.val
   then we search the left of the node N to find node p
 * Time Complexity: worst O(n)
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root!= null && root.val <= p.val) {
            root = root.right;  
        }
        if (root == null) return null;
        //quit while because root.val > p.val
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
}