/**
 * Name: Find Bottom Left Tree Value
 * Number: 513
 * Tag: dfs
 * Main Points: 
   to find the first deepest node, no matter it's right or left.
   pre-order traversal the whole tree, use res[][] to records max depth and corresponding root
 * Time Comlexity: O(n)
 * Space Complexity: O(log n)
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
    public int findBottomLeftValue(TreeNode root) {
        return dfsHelper(root, new int[] {0, 0}, 1);
    }
    private int dfsHelper(TreeNode root, int[] res, int depth) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) {
            dfsHelper(root.left, res, depth + 1);
        }
        if (root.right != null) {
            dfsHelper(root.right, res, depth + 1);
        }
        return res[0];
    }
}