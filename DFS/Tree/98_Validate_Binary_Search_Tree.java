/**
 * Name: Validate Binary Search Tree
 * Number: 98
 * Tag: BST/DFS
 * Main Points:
   (d&c method) BST(root) is valid if: 
   BST(root.left) and BST(root.right) is valid && left tree's max num <= root && right tree's min num >= root. 
   so we need to pass the max value and the min value to next level. base case: BST(null) = valid.
   (iterative method) inorder traversal, a valid BST's inorder travel should be in ascending order.
 * Time Complexity: O(n) (n is the number of nodes in the tree)
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

/************************************* Divide and Conquer **************************************/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return DFSHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);              
    }
    private boolean DFSHelper(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return DFSHelper(root.left, root.val, min) && DFSHelper(root.right, max, root.val);
    }
}
/************************************* Inorder Traversal **************************************/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}