/**
 * Name: Populating Next Right Pointers in Each Node II
 * Number: 117
 * Tag: BFS
 * Main Points: 
   keep 3 variables:
   parent means current level's parent 
   prev means last node (because we want to link a node's previous node to it)
   nextHead means next line's leading node
   we iterate line by line, node by node
 * Time Complexity:  O(n)
 * Space Complexity:  O(1)
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
        
        TreeLinkNode parent = root;
        TreeLinkNode prev;
        TreeLinkNode nextHead;
        
        while (parent != null) { //next line is not empty, enter next line
            //reset nextHead and prev Node
            nextHead = null;
            prev = null;
            while (parent != null) { //loop for each node in current line
                if (nextHead == null) {
                    nextHead = parent.left != null ? parent.left : parent.right;
                }
                
                if (parent.left != null) {
                    if (prev != null) {
                        prev.next = parent.left;
                        prev = prev.next;
                    } else {
                        prev = parent.left;
                    }
                }
                
                if (parent.right != null) {
                    if (prev != null) {
                        prev.next = parent.right;
                        prev = prev.next;
                    } else {
                        prev = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = nextHead;
        }
    }
}