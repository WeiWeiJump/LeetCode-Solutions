/**
 * Name: Reverse Linked List
 * Number: 206
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/******************  iteration  *****************/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
/******************  recursion  *****************/
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseHelper(head, null);
    }
    private ListNode reverseHelper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseHelper(next, head);
    }
}