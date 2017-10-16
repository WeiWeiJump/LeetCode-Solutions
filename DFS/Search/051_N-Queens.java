/**
 * Name: N-Queens
 * Number: 51
 * Tag: DFS/BackTRacking
 * Main Points:
   1. search for valid subset of {1,2,3,4} 
   2.valid means abey the rule of the chess
   3. draw the chess board
   results store all of the chessboards
   cols store the column indices for each row (one chessboard)
 * Time Complexity: < O(n!) (permutation问题)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        List<Integer> cols = new ArrayList<>();
        search(n, results, cols);        
        return results;
    }
    private void search(int n, List results, List<Integer> cols) {
        if (cols.size() == n) {
            results.add(drawChessBoard(n, cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(n, results, cols);
            cols.remove(cols.size() - 1);
        }
    }
    private List<String> drawChessBoard(int n, List<Integer> cols) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder curRow = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (col == cols.get(row)) {
                    curRow.append('Q');
                } else {
                    curRow.append('.');
                }
            }
           board.add(curRow.toString());
        }
        return board;
    }
    private boolean isValid(List<Integer> cols, int colIndex) {
        int row = 0;
        for (int col : cols) {
            if (colIndex == col) {
                return false;
            }
            //在正对角线上
            if (col - row == colIndex - cols.size()) {
                return false;
            }
            //在反对角线上
            if (col + row == colIndex + cols.size()) {
                return false;
            }
            row++;
        }
        return true;
    }
}