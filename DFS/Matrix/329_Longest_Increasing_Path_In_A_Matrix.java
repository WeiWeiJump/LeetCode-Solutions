/**
 * Name: Longest Increasing Path in a Matrix
 * Number: 329
 * Tag: DFS
 * Main Points: 
   To get max length of increasing sequences:
   1.Do DFS from every cell
   2.Compare every 4 direction and skip cells that are out of boundary or smaller
   3.Get matrix max from every cell's max
   4.Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array 
   (we can assure we visit the cells in an acsending order, which will not form a cycle)
   5.The key is to cache the distance because it's highly possible to revisit a cell
**/

class Solution {
    public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        //maxLen represents: for the whole matrix, which node can return the longeset increasing path
        int maxLen = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, m, n, cache));
            }
        }
        return maxLen;
    }
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        //max represents: for one node, what is the max increasing path of four directions
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}