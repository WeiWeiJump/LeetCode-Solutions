/**
 * Name: Intersection of Two Linked Lists
 * Number: 160
 * Tag: Linkedlist tricky
 * Main Points:
   the key of the problem is difference of lengths of two linkedlist
   however we don't care about the exact value of the difference, 
   we just want to make sure two pointers reach the intersection at the same time
   We can use two iterations to do that. 
   In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist
   after it reaches the tail node.
   In the second iteration, they are bound to meet at same point, 
   if two linkedlists intersect, it's the intersection node
   if they don't have intersection, they are to meet at null
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}