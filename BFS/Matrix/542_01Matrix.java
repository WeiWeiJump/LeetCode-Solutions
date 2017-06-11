/**Name:01 Matrix
 * Number: 542
 * Tag: BFS
 * Time Complexity: O(n)
**/
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        //add all 0 point to queue
        //mark all 1 point to be Integer.MAX_VALUE
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int column = cell[1] + dir[1];
                if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) continue;
                //If a cell's distance has been calculated, then we don't need to explore that cell again
                if (matrix[row][column] < Integer.MAX_VALUE) continue;
                queue.offer(new int[]{row, column});
                matrix[row][column] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}