/**
 * Name: Populating Next Right Pointers in Each Node
 * Number: 116
 * Tag: BFS
 * Main Points: leve-order traversal
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode curNode = queue.poll();
                //add next level to the queue
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                //link current level
                curNode.next = prev;
                prev = curNode;
            }
        }
        return;      
    }
}