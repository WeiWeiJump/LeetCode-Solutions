/**
 * Main Points: 
 Assume sum is the sum of nums[]. 
 The dfs process is to find a subset of nums[] which sum equals to sum/k. 
 We use an array visited[] to record which element in nums[] is used. 
 Each time when we get a cur_sum = sum/k, 
 we will start from position 0 in nums[] to look up the elements that are not used yet and find another cur_sum = sum/k.
 * Time Complexity:
 * Space Complexity: O(n) n = nums.length
**/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (k <= 0 || sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return canPartitionHelper(nums, k, 0, 0, sum / k, visited);
    }
    private boolean canPartitionHelper(int[] nums, int k, int start, int curSum, int target, boolean[] visited) {
        if (k == 1) return true;
        if (curSum > target) return false;
        if (curSum == target) return canPartitionHelper(nums, k - 1, 0, 0, target, visited);
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartitionHelper(nums, k, i + 1, curSum + nums[i], target, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}