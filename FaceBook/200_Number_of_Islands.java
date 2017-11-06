/**
 * Name: Number of Islands
 * Number: 200
 * Tag: DFS
 * Time Complexity: O(num of island * 4^(num of 1) + O(mn - num of 1))
 * Space Complexity: O(longest path)
**/
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
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
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            explore(grid, nextI, nextJ);
        }
    }
    
}