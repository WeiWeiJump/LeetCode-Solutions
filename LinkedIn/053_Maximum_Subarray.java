/**
 * Main Points: 
   means the maxSubArray for nums[0] ~ nums[i] which must has nums[i] as the end element
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        //dp[i]表示以nums[i]结尾的maxSubArray Sum
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}