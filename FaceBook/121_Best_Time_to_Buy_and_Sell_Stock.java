/**
 * Name: Best Time to Buy and Sell Stock
 * Number: 121
 * Tag: Array
 * Main Points: find diff array's maximum subarray
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 **/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] diff = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        return maxSubArray(diff);
    }
    private int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int preMax = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {      
            preMax = Math.max(0, preMax + nums[i]);
            max = Math.max(max, preMax);
        }  
        return max;
    }
}