/**
 * Main Points: DP: 
 minCost[i][j] represent minimum price to paint the i th house with color j plus painting all i - 1 houses 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[][] minCost = new int[costs.length][costs[0].length];
        //initialize
        for (int i = 0; i < 3; i++) {
            minCost[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            minCost[i][0] = costs[i][0] + Math.min(minCost[i - 1][1], minCost[i - 1][2]);
            minCost[i][1] = costs[i][1] + Math.min(minCost[i - 1][0], minCost[i - 1][2]);
            minCost[i][2] = costs[i][2] + Math.min(minCost[i - 1][0], minCost[i - 1][1]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(minCost[n][0], minCost[n][1]), minCost[n][2]);
    }
}