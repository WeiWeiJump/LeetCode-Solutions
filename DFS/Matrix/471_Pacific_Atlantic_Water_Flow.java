/**Name: Pacific Atlantic Water Flow
 * Number: 417
 * Tag: DFS
 * Time Comlexity: O(mn) m = matrix.length, n = matrix[0].length
 * Space Compexity: O(mn)
**/
public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        boolean[][] pacific = new boolean[row][column];
        boolean[][] atlantic = new boolean[row][column];
        
        for (int i = 0; i < column; i++) {
            DFS(matrix, pacific, row, column, 0, i);
            DFS(matrix, atlantic, row, column, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            DFS(matrix, pacific, row, column, i, 0);
            DFS(matrix, atlantic, row, column, i, column - 1);
        }
        
        for (int i = 0; i < row; i++) {
            for ( int j = 0; j < column; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    private void DFS(int[][] matrix, boolean[][] visited, int row, int column, int r, int c) {
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int rAdjacent = r + dir[0];
            int cAdjacent = c + dir[1];
            if (rAdjacent < 0 || rAdjacent >= row || cAdjacent < 0 || cAdjacent >= column 
            || visited[rAdjacent][cAdjacent] || matrix[r][c] > matrix[rAdjacent][cAdjacent]) {
                continue;
            }
            DFS(matrix, visited, row, column, rAdjacent, cAdjacent);
        }
    }
}