/**
 * Name: Sparse Matrix Multiplication
 * Number: 311
 * Tag: tricky
 * Main Points: How to use Sparse?
   C[i][j] = Sum(A[i][k] * B[k][j])
   we needn't to calculate this sum at once and imediately
 * Time Complexity: O(not sparse point in A * columnB)
 * Space Complexity: O(1)
**/
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        //corner case: A/B null
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) {
                        if (B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}