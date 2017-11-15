/**
 * Name: Best Time to Buy and Sell Stock with Transaction Fee
 * Number: 714
 * Tag: DP
 * Main Points:
   I define hold[i] as the maximum profit that I could obtain when I hold a stock on day i. 
   How can I hold a stock on day i ?
   (1) Before day i, I am already holding a stock and I do nothing on day i.
   The profit is hold[i - 1].
   (2) Before day i, I don't hold any stock and I have to buy a stock on day i
 
   nothold[i] is similar.
 * Time Complexity: O(n)
 * Space Complexity: O(2n)
**/
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        //dp: hold[i] means the maximum profit that I could obtain when I hold a stock on day i
        int[] hold = new int[prices.length];
        int[] nothold = new int[prices.length];
        
        //initialize
        hold[0] = -prices[0] - fee;
        nothold[0] = 0;
        
        //dp
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], nothold[i - 1] - prices[i] - fee);
            nothold[i] = Math.max(nothold[i - 1], hold[i - 1] + prices[i]);
        }
        return Math.max(hold[prices.length - 1], nothold[prices.length - 1]);
    }
}