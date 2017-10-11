/**
 * Name: 01 Matrix
 * Number: 542
 * Tag: BFS
 * Main Points:
   BFS: From what's most closed to 0, then level by level visit next point.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
/*******************************  BFS  **************************/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][] {{}};
        }
        int row = matrix.length, column = matrix[0].length;       
        Queue<int[]> queue = new LinkedList<>();
        //initialize the queue by offering all 0s to it
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // BFS
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= column || matrix[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[] {x, y});
                matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
            }
        }
        return matrix;
    }
}