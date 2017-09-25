/**
 * Name: Populating Next Right Pointers in Each Node II
 * Number: 117
 * Tag: 
 * Main Points: iterate vertically from the tree's top to the bottom, 
   then inside the iteration, iterate through this level
   so we need to store each level's head, parent node and current node
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
        TreeLinkNode nextHead = null;
        TreeLinkNode prevNode = null;
        
        while (parent != null) {
            //initialize (change to a new line)
            //prev can be regarded as a dummy node in front of each line
            nextHead = null;
            prevNode = null;
            while (parent != null) {
                if (nextHead == null) {
                    nextHead = (parent.left != null) ? parent.left : parent.right;
                }
                if (parent.left != null) {
                    if (prevNode != null) {
                        prevNode.next = parent.left;
                        prevNode = prevNode.next;
                    } else {
                        prevNode = parent.left;
                    }    
                } 
                if (parent.right != null) {
                    if (prevNode != null) {
                        prevNode.next = parent.right;
                        prevNode = prevNode.next;
                    } else {
                        prevNode = parent.right;
                    }
                }
                parent = parent.next;               
            }
            parent = nextHead;
        }
    }
}