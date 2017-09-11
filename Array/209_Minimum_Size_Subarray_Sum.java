/**
 * Name: Minimum Size Subarray Sum
 * Number: 209
 * Tag: 2 pointers
 * Main Point: keep 2 pointers - start & end
   start is the first element in the subarray, end is the last..
   if the sum from start to end < target, then end moves 1 pos rightside
   if the sum from start tp end >= target, then start moves 1 pos rightside
   keep recording the length of the subarray and update the min lenth.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = 0;
        int sumOfSubarray = nums[end];
        int minLen = (nums.length == 1 && nums[0] >= s) ? 1 : Integer.MAX_VALUE;
        while (end < nums.length) {
            if (sumOfSubarray < s) { 
                    end++;
                if (end < nums.length) {
                    sumOfSubarray += nums[end]; 
                }               
            } else {
                minLen = Math.min(minLen, end - start + 1);
                sumOfSubarray -= nums[start];
                start++;
            }   
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}