/**
 * Name: Linked List Cycle
 * Number: 141
 * Tag: 
 * Main Points: 
   keep a walker and a runner
   walker moves step by step
   runner moves 2 steps at a time
   if there is a cycle in the likedlist
   walker and runner are to meet at a time
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) return true;
        }
        return false;
    }
}