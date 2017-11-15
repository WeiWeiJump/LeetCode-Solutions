/**
 * Name: Longest Continuous Increasing Subsequence
 * Number: 674
 * Tag: DP
 * Main Points:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //dp[i] represents 以nums[i]结尾的LIS的长度
        int[] dp = new int[nums.length];
        //initialize
        dp[0] = 1;
        //dp
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {  
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}