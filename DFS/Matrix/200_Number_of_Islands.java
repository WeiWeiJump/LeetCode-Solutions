/**
 * Name: Number of Islands
 * Number: 200
 * Tag: DFS
 * Main Points: 
   DFS in 4 direction, all visited area should be marked.
   First I used boolean[][] to store whether it's visited.
   In fact we can save space by change every visited island to water.
 * Time Comlexity: O(row * column)
 * Space Complexity: Worst O(row * column)
**/
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        //boolean[][] visited = new boolean[row][column];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        explore(grid, i - 1, j);
        explore(grid, i + 1, j);
        explore(grid, i, j - 1);
        explore(grid, i, j + 1);        
    }
}