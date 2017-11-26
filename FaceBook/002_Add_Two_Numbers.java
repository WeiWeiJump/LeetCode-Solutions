/**
 * Name: Add Two Numbers
 * Number: 2
 * Tag:
 * Main Points:
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
                
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode ptr1 = l1, ptr2 = l2;
        int carry = 0;
        while (ptr1 != null || ptr2 != null || carry != 0) {
            int sum = carry;
            if (ptr1 != null) {
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }
        return dummy.next;
    }
}