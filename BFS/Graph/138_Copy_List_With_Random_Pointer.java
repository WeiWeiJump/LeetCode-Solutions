/**
 * Name: Copy List with Random Pointer
 * Number: 138
 * Tag: HashMap/Graph
 * Time Complexity: O(n)
**/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, new RandomListNode(head.label));
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curNode = head, prev = dummy;
        
        while (curNode != null) {
            //copy .next point
            if (!map.containsKey(curNode)) {
                map.put(curNode, new RandomListNode(curNode.label));
            }
            RandomListNode newNode = map.get(curNode);
            prev.next = newNode;
            
            //copy .random point
            if (curNode.random != null) {
                if (!map.containsKey(curNode.random)) {
                    map.put(curNode.random, new RandomListNode(curNode.random.label));
                }
                newNode.random = map.get(curNode.random);
            }
            prev = newNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }
}