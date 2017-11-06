/**
 * Name: Kth Largest Element in an Array
 * Number: 215
 * Tag: heap
 * Main Points: use a priority queue(min_heap) to keep recording K current largest elements
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
**/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}