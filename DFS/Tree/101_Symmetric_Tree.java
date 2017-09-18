/**
 * Name: Symmetric Tree
 * Number: 101
 * Tag: DFS
 * Main Points: pass in the value that should be at symmetric location, 
compare their value, if they are the same, check whether their next level is symmetric.
 * Time Complexity: O(n)
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
/****************************************** Recursion *****************************************/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmHelper(root.left, root.right);
    }
    private boolean isSymmHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmHelper(left.left, right.right) && isSymmHelper(left.right, right.left);
    }
}
/****************************************** Iteration *****************************************/ 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) return root.left == root.right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left.val != right.val) return false;
            if (left.left != null && right.right != null) {
                queue.offer(left.left);
                queue.offer(right.right);
            }
            if ((left.left != null && right.right == null) || (left.left == null && right.right != null)) {
                return false;
            }
            if (left.right != null && right.left != null) {
                queue.offer(left.right);
                queue.offer(right.left);
            }
            if ((left.right != null && right.left == null) || (left.right == null && right.left != null)) {
                return false;
            }
        }
        return true;
    }
}