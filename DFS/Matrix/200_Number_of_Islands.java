/**Name: NumberOfIslands
 * Number: 200
 * Tag: DFS
 * Time Complexity: O(n) (n is the number of matrix)
**/
public class Solution {

    int count = 0;
    int[] rDir = {-1, 0, 1, 0};
    int[] cDir = {0, -1, 0, 1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0 ; c < column; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    explore(grid, row, column, r , c, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void explore(char[][] grid, int row, int column, int r, int c, boolean[][] visited) {
        if (!shouldExplore(grid, row, column, r, c, visited)) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            explore(grid, row, column, r + rDir[i], c + cDir[i], visited);
        }
    }
    private boolean shouldExplore(char[][] grid, int row, int column, int r, int c, boolean[][] visited) {
        if (r >= 0 && r < row && c >= 0 && c < column && grid[r][c] == '1' && !visited[r][c]) {
            return true;
        }
        return false;
    }