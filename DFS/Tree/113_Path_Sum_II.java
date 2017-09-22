/**
 * Name: Path Sum II
 * Number: 113
 * Tag: DFS
 * Main Point: post-order traversal the tree, backtracking if the path sum is not equal to sum.
   where we should backtraking:
   when a path go to its end, remove the last one, then we can add new element in.
   when dealing with a node, find all the left subtree's path, all the right subtree's path.
   only after then can we delete current node.
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();      
        pathSumHelper(root, sum, res, path);
        return res;
    }
    private void pathSumHelper(TreeNode root, int sum, List res, List path) {
        if (root == null) return;
        
        path.add(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        pathSumHelper(root.left, sum - root.val, res, path);
        pathSumHelper(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}