/**
 * Name: Sum Root to Leaf Numbers
 * Number: 129
 * Tag: DFS
 * Main Points: DFS all the path and do some calculation from the top to bottom
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
 ****** Same as 113_Path Sum II ******
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
    public int sumNumbers(TreeNode root) {      
        List<Integer> allPathSum = new ArrayList<>();
        sumNumbersHelper(root, 0, allPathSum);
        
        int ret = 0;
        for (int n : allPathSum) {
            ret += n;
        }
        return ret;
    }
    private void sumNumbersHelper(TreeNode root, int sum, List res) {
        if (root == null) return;
        sum = sum *10 + root.val;
        if (root.left == null && root.right == null) {
            res.add(new Integer(sum));
            sum = sum - root.val;
            return;
        }
        sumNumbersHelper(root.left, sum, res);
        sumNumbersHelper(root.right, sum, res);
        sum = sum - root.val;
    }
}