/**
 * Main Points: DP
 * Time Complexity: O(n)
 * Space Complexity: O(n) -> can be improved to O(1) using % 2
**/
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxProduct = nums[0];
        int[] maxDP = new int[nums.length], minDP = new int[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxDP[i] = Math.max(minDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], nums[i]);
            } else {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(minDP[i - 1] * nums[i], nums[i]);
            }
            maxProduct = Math.max(maxProduct, maxDP[i]);
        }
        return maxProduct;
    }
}