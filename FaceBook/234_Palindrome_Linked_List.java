/**
 * Name: Palindrome Linked List
 * Number: 234
 * Tag: LinkedList
 * Main Points: first find middle node, then reverse middle, and then compare
 * Time Complexity: O(n)
 * Space Complexity: 严格O(n) 广义O(1)
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        
        ListNode ln1 = head, ln2 = middle.next;
        while (ln1 != null && ln2 != null && ln1.val == ln2.val) {
            ln1 = ln1.next;
            ln2 = ln2.next;
        }
        return ln2 == null;
    }
    private ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
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