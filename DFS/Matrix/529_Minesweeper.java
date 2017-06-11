/**Name: Minesweeper
 * Number: 529
 * Tag: DFS/BFS
 * Time Complexty: O(n)
**/
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int count = 0;
        int row = click[0], column = click[1];
        
        //1.If click on a mine ('M'), mark it as 'X', stop further search.
        if (board[row][column] == 'M') {
            board[row][column] = 'X';
            //2.If click on an empty cell ('E'), depends on how many surrounding mine:
        } else if (board[row][column] == 'E') {
        	//count the number of surrounding mines;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (j == 0 && i == 0) continue;
                    int r = row + i, c = column + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if(board[r][c] == 'M') {
                        count++;
                    }
                }
            }
            //2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
            if (count != 0) {
                board[row][column] = (char)(count + '0');
            //2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
            } else {
                board[row][column] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (j == 0 && i == 0) continue;
                        int r = click[0] + i, c = click[1] + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') {
                            updateBoard(board, new int[]{r, c});
                        }
                    }
                }
            }
        }
        return board;
    }
}