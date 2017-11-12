/**
 * Name: Target Sum
 * Number: 494
 * Tag: DFS/DP
**/

/************************ DFS ***********************/
/* Main Points: 
   naive version: Just do DFS and try both "+" and "-" at every position
   improved version: check the sum of left numbers, if it's less than target, we can return
 * Time Complexity: worst O(2^n)
 * Space Complexity: O(nums.length)
 */

class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length];
        sum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }
        dfsHelper(nums, sum, S, 0);
        return res;
    }
    private void dfsHelper(int[] nums, int[] sum, int target, int pos) {
        if (pos == nums.length) {
            if (target == 0) {
                res++;
            }
            return;
        }
        if (sum[pos] < Math.abs(target)) return;
        dfsHelper(nums, sum, target - nums[pos], pos + 1);
        dfsHelper(nums, sum, target + nums[pos], pos + 1);
    }
}


/************************ DP ************************/
/* Main Points: 
   first we want to use dp[i][j] to represent the ways that make +/-nums[0] +/-....nums[i] = j
   but the sum could be negative, can not be implemented as an index
   thus, we shift the sum by its range (eg, we calculate nums' sum's range), 
   then, we use dp[i][j + range] to represent the ways that make +/-nums[0] +/-....nums[i] = j
 * Time Complexity: O(nums.length * range)
 * Space Complexity: O(nums.length * range)
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) return 0;
        int range = 0;
        //nums are all positive, get range
        for (int num : nums) {
            range += num;
        }
        if (range < Math.abs(S)) return 0;
        
        //definition: dp[i][j + range] represent the ways that make +/-nums[0] +/-....nums[i] = j
        int doubleRange = range << 1;
        int[][] dp = new int[nums.length][doubleRange + 1]; //from -range to +range
        
        //init dp
        if (nums[0] == 0) {
            dp[0][range] = 2; // +0, -0
        } else {
            dp[0][range + nums[0]] = 1;
            dp[0][range - nums[0]] = 1;
        }
        
        //dp
        for (int i = 1; i < nums.length; i++) {
            //Arrays.fill(dp[i % 2], 0);
            for (int j = 0; j <= doubleRange; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] <= doubleRange) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][S + range];
        
    }
    
}

/******************** DP Space Improvement ********************/
/*
 main Points: use 滚动数组优化空间
 Space Complexity: O(range)
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) return 0;
        int range = 0;
        //nums are all positive, get range
        for (int num : nums) {
            range += num;
        }
        if (range < Math.abs(S)) return 0;
        
        //definition: dp[i][j + range] represent the ways that make +/-nums[0] +/-....nums[i] = j
        int doubleRange = range << 1;
        int[][] dp = new int[2][doubleRange + 1]; //from -range to +range
        
        //init dp
        if (nums[0] == 0) {
            dp[0][range] = 2; // +0, -0
        } else {
            dp[0][range + nums[0]] = 1;
            dp[0][range - nums[0]] = 1;
        }
        
        //dp
        for (int i = 1; i < nums.length; i++) {
            Arrays.fill(dp[i % 2], 0);
            for (int j = 0; j <= doubleRange; j++) {
                if (j - nums[i] >= 0) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j - nums[i]];
                }
                if (j + nums[i] <= doubleRange) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j + nums[i]];
                }
            }
        }
        return dp[(nums.length - 1) % 2][S + range];
        
    }
}