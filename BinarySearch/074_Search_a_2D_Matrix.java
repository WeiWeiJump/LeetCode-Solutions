/**
 * Name: Search a 2D Matrix
 * Number: 74
 * Tag: Binary Search
 * Time Complexity: O(log(m*n)), m = matrix.length, n = matrix[0].length
 * Space Complexity: O(1)
**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, column = matrix[0].length;
        int start = 0, end = row * column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int r = mid / column, c = mid % column;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / column][start % column] == target) {
            return true;
        }
        if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }
}