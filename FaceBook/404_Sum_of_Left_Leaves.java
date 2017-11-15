/**
 * Name: Sum of Left Leaves
 * Number: 404
 * Tag: binary tree
 * Main Points:
   BFS traverse the tree, 
   if a left node is a leaf, add it to ans
   if not, push it into stack
   if a right node is a leaf, skip it
   if not, push it into stack
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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    ans += cur.left.val;
                } else {
                    queue.offer(cur.left);
                }
            }
            if (cur.right != null) {
                if (cur.right.left != null || cur.right.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return ans;
    }
}