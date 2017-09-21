/**
 * Name: Convert Sorted List to Binary Search Tree
 * Number: 109
 * Tag: DFS
 * Main Point: similar with 108. 
   The trick is we use 2 pointers to find the mid of the linkedlist
   and then recursively build the tree like 108.
 * Time Complexity: O()
 * Space Complexity: O()
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        //initialize tail to be null
        return toBSTHelper(head, null);
    }
    private TreeNode toBSTHelper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        //find the mid of the linkedlist
        ListNode fast = head, slow = head;
        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;     
        }
        //now slow is the mid of the list
        TreeNode curRoot = new TreeNode(slow.val);
        curRoot.left = toBSTHelper(head, slow);
        curRoot.right = toBSTHelper(slow.next, tail);
        
        return curRoot;
    }
}