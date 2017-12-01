/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Main Points: draw pictures
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode prev = null, cur = root, next = null, temp = null;
        
        while (cur != null) {
            next = cur.left;
            
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            
            prev = cur;
            cur = next;
        }
        return prev;
    }
}