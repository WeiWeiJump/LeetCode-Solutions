/**
 * Name: Pacific Atlantic Water Flow
 * Number: 417
 * Tag: DFS
 * Main Points: 
   use matrix canFlowToP to record whether a point can flow to Pacific
   use matrix canFlowToA to record whether a point can flow to Atalantic
   (DFS from the ocean to the highest position)
   return the points that can both flow to Pacific and Atalantic
**/
class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        boolean[][] canFlowToP = new boolean[matrix.length][matrix[0].length];
        boolean[][] canFlowToA = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            dfs(i, 0, matrix, canFlowToP, Integer.MIN_VALUE);
            dfs(i, matrix[0].length - 1, matrix, canFlowToA, Integer.MIN_VALUE);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(0, j, matrix, canFlowToP, Integer.MIN_VALUE);
            dfs(matrix.length - 1, j, matrix, canFlowToA, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (canFlowToP[i][j] && canFlowToA[i][j]) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, int[][] matrix, boolean[][] visited, int height) {
        int rLimit = matrix.length, cLimit = matrix[0].length; 
        if (r < 0 || r >= rLimit || c < 0 || c >= cLimit || visited[r][c] || matrix[r][c] < height) {
            return;
        }
        visited[r][c] = true;
        for (int[] dir : dirs) {
            dfs(r + dir[0], c + dir[1], matrix, visited, matrix[r][c]);
        }
    }
}