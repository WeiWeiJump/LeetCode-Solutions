/**Name: Longest Increasing Path in a Matrix
 * Number: 329
 * Tag: DFS + Memorization
 * Time Comlexity: O(mn)
 * Every cell that has been computed will not be computed again, only a value look-up is performed. 
 * So this is O(mn), m and n being the width and height of the matrix.
 * Ideas: 
 * 1. Do DFS from every cell
 * 2. Compare every 4 direction and skip cells that are out of boundary or smaller
 * 3. Get matrix max from every cell's max
 * 4. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * 5. The key is to cache the distance because it's highly possible to revisit a cell
**/
public class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int row = matrix.length;
        int column = matrix[0].length;
        int maxLength = 0; // max length for whole matrix
        int[][] cache = new int[row][column];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int curMaxLength = explore(matrix, row, column, i, j, cache);
                maxLength = Math.max(maxLength, curMaxLength);
            }
        }
        return maxLength;
    } 
    private int explore(int[][] matrix, int row, int column, int r, int c, int[][] cache) {
        if (cache[r][c] != 0) return cache[r][c];
        
        int maxLenOfPoint = 1;
        for (int[] dir : dirs) {
            int rAdjacent = r + dir[0];
            int cAdjacent = c + dir[1];
            if (rAdjacent < 0 || rAdjacent >= row || cAdjacent < 0 || cAdjacent >= column || matrix[r][c] >= matrix[rAdjacent][cAdjacent]) continue;
            int maxLenOfDir = 1 + explore(matrix, row, column, rAdjacent, cAdjacent, cache); //max length of this direction
            maxLenOfPoint = Math.max(maxLenOfPoint, maxLenOfDir); //max length of this point
        }
        cache[r][c] = maxLenOfPoint;
        return maxLenOfPoint;
    }
}