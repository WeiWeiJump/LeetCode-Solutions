/**
 * Name: Maximal Square
 * Number: 221
 * Tag: DP
 * Main Points:
   dp[i][j] represents the max sideLength of a square
   whose right-lower corner is located at (i, j) in matrix
   if matrix[i][j] == 1, we could possible find a matrix
   by looking at max sideLength of a square whose right-lower corner is located at (i - 1, j), (i, j -1)
   and also, (i - 1, j - 1)
   because Top, Left, and Top Left decides the size of the square.
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
**/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        //dp: the max sideLength of a square whose right-lower corner is located at (i, j) in matrix
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        
        //initialize
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxSide = Math.max(maxSide, dp[0][j]);
        }
        
        //dp
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        //return square
        return maxSide * maxSide;
    }
}