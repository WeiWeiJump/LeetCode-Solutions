/**
 * Name: Combination Sum IV
 * Number: 377
 * Tag: DFS
 * Main Points: dp[i] represent how many ways that elements in the nums array sum up to j
 * Time Complexity: O(n * target)
 * Space Complexity: O(target)
**/
class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        //definition: dp[i] represent how many ways that elements in the nums array sum up to j
        int[] dp = new int[target + 1];     
        //inilialize
        dp[0] = 1;
        //dp
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }              
            }
        }
        return dp[target];
    }
  
}