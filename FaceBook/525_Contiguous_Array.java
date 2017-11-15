/**
 * Name: Contiguous Array
 * Number: 525
 * Tag: preSum + HashMap
 * Main Points:
   change all 0s to -1s, so when there are even -1s(0s) and 1s, they will sum up to 0
   if preSum(i) == presum(j), then there are equal 0 and 1s between i and j
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }       
        int runningSum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (map.containsKey(runningSum)) {
                maxLen = Math.max(maxLen, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return maxLen;
    }
}