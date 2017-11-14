/**
 * Name: Minimum Size Subarray Sum
 * Number: 209
 * Tag: 2 pointers
 * Main Points: 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int slow = 0, fast = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (fast < nums.length) {
            sum += nums[fast++];
            while (sum >= s) {
                minLen = Math.min(minLen, fast - slow);
                sum -= nums[slow++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}