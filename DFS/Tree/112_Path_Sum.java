/**
 * Name: Path Sum
 * Number: 112
 * Tag: DFS
 * Main Points: divide & conquer, also pay attention to the case when root.left or root.right == null
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
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return pathSumHelper(root, sum);
    }
    public boolean pathSumHelper(TreeNode root, int sum) {
        if (root == null) return sum == 0 ? true : false;
        if (root.left != null && root.right != null) {
            return pathSumHelper(root.left, sum - root.val) || pathSumHelper(root.right, sum - root.val);
        }
        if (root.left != null) {
            return pathSumHelper(root.left, sum - root.val);
        }
        if (root.right != null) {
            return pathSumHelper(root.right, sum - root.val);
        }
        return sum == root.val;
    }
}