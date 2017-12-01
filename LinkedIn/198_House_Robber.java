/**
 * Main Points: dp[i][0]表示第i家不偷，从第0到第i个数的最大抢劫金额
 * Time Complexity: O(n) n = nums.length
 * Space Complexity: O(n) -> can be improved to O(1)
**/
class Solution {
    public int rob(int[] nums) {// 5 2 1 3 5 7
        int[][] dp = new int[nums.length + 1][2];
        //dp[i][0]表示第i家不偷，从第0到第i个数的最大抢劫金额
        //dp[i][1]表示第i家偷，从第0到第i个数的最大抢劫金额
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
//space -> O(1)
class Solution {
    public int rob(int[] nums) {// 5 2 1 3 5 7
        int prevNo = 0, prevYes = 0;
        //dp[i][0]表示第i家不偷，从第0到第i个数的最大抢劫金额
        //dp[i][1]表示第i家偷，从第0到第i个数的最大抢劫金额
        for (int i = 1; i <= nums.length; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i - 1];
        }
        return Math.max(prevNo, prevYes);
    }
}