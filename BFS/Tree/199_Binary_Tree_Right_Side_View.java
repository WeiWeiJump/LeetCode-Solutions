/**
 * Name: Binary Tree Right Side View
 * Number: 199
 * Tag: BFS/DFS
 * Main Points: 
   BFS: level-order traversal and add each level's last point to the list
   DFS: traversal in the order right, left, root
 * Time Complexity: O(n)
 * Space Complexity: BFS: O(n) DFS: Average O(logn) worst O(n)
 
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

/***************************   BFS   *************************/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == size - 1) {
                    res.add(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return res;
    }
}
/***************************   DFS   *************************/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(root, res, 0);
        return res;
    }
    private void rightSideViewHelper(TreeNode root, List res, int curLevel) {
        if (root == null) return;
        if (curLevel == res.size()) {
            res.add(root.val);
        }
        rightSideViewHelper(root.right, res, curLevel + 1);
        rightSideViewHelper(root.left, res, curLevel + 1);
    }
}