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
 * Main Points: BFS use a maxInLevel to record max number in each row
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new ArrayList<>();
        if (root == null) return maxValues;
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int maxInLevel = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                maxInLevel = Math.max(maxInLevel, cur.val);
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
            maxValues.add(maxInLevel);
        }
        return maxValues;
    }
}