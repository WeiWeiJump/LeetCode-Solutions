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
/**
 * Main Points: 
   Let the distance from the first node to the the node where cycle begins be A, 
   and let say the slow pointer travels travels A+B. 
   The fast pointer must travel 2A+2B to catch up. The cycle size is N. 
   Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.
   
   From our calculation slow pointer traveled exactly full cycle when it meets fast pointer, 
   and since originally it travled A before starting on a cycle, 
   it must travel A to reach the point where cycle begins! 
   We can move slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
                    
            if (fast == slow){
                slow = head; 
                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}