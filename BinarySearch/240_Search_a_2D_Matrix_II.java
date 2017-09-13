/**
 * Name: Search a 2D Matrix II
 * Number: 240
 * Tag: Binary Search
 * Main Point: (Dirty trick) from the bottom left A(m, n), then all the numbers on row m should be larger than A
   all the numbers on column n should be less than A. so if target is larger than A, then move the crrent point 
   1 position to right; if target is smaller than A, move the current point 1 position up .
 * Time Comlexity: O(m + n) (m = matrix.length, n = matrix[0])
 * Space Complexity:
**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int pRow = matrix.length - 1, pColumn = 0;
        while (pRow >= 0 && pColumn < matrix[0].length) {
            if (matrix[pRow][pColumn] == target) {
                return true;
            } else if (matrix[pRow][pColumn] < target) {
                pColumn++;
            } else {
                pRow--;
            }
        }
        return false;
    }
}