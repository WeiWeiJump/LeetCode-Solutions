/**
 * Name: Binary Tree Vertical Order Traversal
 * Number: 314
 * Tag: BFS
 * Main Points: 
   1. BFS: put node and col into the queue at the same time
   2. Every left child access col - 1 while right child col + 1
   3. This maps node into different col buckets
   4. Get col boundary min and max on the fly
   5. Retrieve result from cols
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> cols = new LinkedList<>();
        
        queue.offer(root);
        cols.offer(0);
        
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curCol = cols.poll();
            
            if (!map.containsKey(curCol)) {
                map.put(curCol, new ArrayList<Integer>());
            }
            map.get(curCol).add(cur.val);
            
            if (cur.left != null) {
                queue.offer(cur.left);
                cols.offer(curCol - 1);
                min = Math.min(curCol - 1, min);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                cols.offer(curCol + 1);
                max = Math.max(curCol + 1, max);
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}