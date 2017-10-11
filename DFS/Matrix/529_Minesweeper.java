/**
 * Name: Minesweeper
 * Number: 529
 * Tag: DFS
 * Main Points:
   first, we only need to do with the case when clicking on 'M' or 'E'
   if user click on anything revealed ('B' or digit or 'X'), give no response
   1. if click on 'M', change 'M' to 'X'
   2. if click on 'E', count adjacent mines
      1. if there is no adj mines, DFS all its adj mines
      2. if there is adj mines, expose it
 * Time Complexity: O(n)
 * Space Complexity: worst O(n)
**/
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        //throw exception here is better
        if (board == null || board.length == 0 || board[0].length == 0 || click == null || click.length == 0) {
            return new char[][]{{}};
        }
        
        char clicked = board[click[0]][click[1]];
        if (clicked == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (clicked == 'E') {
            //count adjacent mines
            int count = adjMines(board, click[0], click[1]);
            if (count > 0) {
                board[click[0]][click[1]] = (char)(count + '0');
                return board;
            } else {
                dfs(board, click[0], click[1], count);
                return board;
            }
        }
        return board;
    }
    private int adjMines(char[][] board, int x, int y) {
        int xLimit = board.length, yLimit = board[0].length;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int curX = x + i, curY = y + j;
                if (curX < 0 || curX >= xLimit || curY < 0 || curY >= yLimit || (i == 0 && j == 0)) {
                    continue;
                }
                if (board[curX][curY] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private void dfs(char[][] board, int x, int y, int count) {
        int xLimit = board.length, yLimit = board[0].length;
        if (x < 0 || x >= xLimit || y < 0 || y >= yLimit || board[x][y] != 'E') {
            return;
        }
        if (count > 0) {
            board[x][y] = (char)(count + '0');
            return;
        } 
        
        board[x][y] = 'B';
        for (int[] dir : dirs) {
            int nextX = x + dir[0], nextY = y + dir[1];
            dfs(board, nextX, nextY, adjMines(board, nextX, nextY));
        }     
    }
}