/**Name: N Queens
 * Number: 51
 * Tag: DFS/Backtraking
 * Root: 46.Permuations
 * Time Complexity: O(n!)
**/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        List<Integer> cols = new ArrayList<>();
        search(n, res, cols);
        return res;
    }
    private void search(int n, List<List<String>> res, List<Integer> cols) {
        if (cols.size() == n) {
            res.add(drawChessBoard(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(n, res, cols);
            cols.remove(cols.size() - 1);
        }
    }
    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessBoard = new ArrayList<>();
        for (int row = 0; row < cols.size(); row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.size(); col++) {
                sb.append(col == cols.get(row) ? "Q" : ".");
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (column == cols.get(rowIndex)) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
}