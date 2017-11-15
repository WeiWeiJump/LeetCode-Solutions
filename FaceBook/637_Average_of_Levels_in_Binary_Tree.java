/**
 * Name: Average of Levels in Binary Tree
 * Number: 637
 * Tag: BFS
 * Main Points: 
   level order traversal
   keep a variable size to count each level's nodes
   keep a variable sum to calculate each level's sum
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        long sum;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add((double)sum / size);
        }
        return res;    
    }
}