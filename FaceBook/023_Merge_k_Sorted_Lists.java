/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Main Points: using heap
 * Time Complexity: O(nlogk) k=number of lists, n=number of elements a list contains
 * Space Complexity: O(k)
**/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode ln1, ListNode ln2) {
                return ln1.val - ln2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }     
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}