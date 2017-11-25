/**
 * Name: Reorder List
 * Number: 143
 * Main Points:
   3 steps: 
   Find the middle of the list
   Reverse the half after middle  1->2->3->4->5->6->null to 1->2->3->null 6->5->4->null
   merge to 1->6->2->5->3->4
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //find middle
        ListNode mid = findMiddle(head);
        //reverse linkedlist
        ListNode tail = reverse(mid.next);
        mid.next = null;
        //merge tow linkedlist
        merge(head, tail);
    }
    private ListNode findMiddle(ListNode head) {
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
    
    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
}