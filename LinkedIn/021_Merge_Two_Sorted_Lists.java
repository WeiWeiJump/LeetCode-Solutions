/**
 * Name: Merge Two Sorted Lists
 * Number: 21
 * Tag: 2 pointers
 * Main Points: 
 // 1->3->5->7->null
 // 2->4->6->8->10->null
 * Time Complexity: O(l1.length + l2.length)
 * Space Complexity: O(l1.length + l2.length)
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}