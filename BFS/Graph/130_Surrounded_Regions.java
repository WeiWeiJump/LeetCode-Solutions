/**
 * Name: Surrounded Regions
 * Tag: 130
 * Idea:
 * first find all 'O's on the edge, and do BFS from these 'O's. Keep adding 'O's into the queue in the BFS, and mark it as '*'. 
 * Since these 'O's are found by doing BFS from the 'O's on the edge, it means they are connected to the edge 'O's. 
 * so they are the 'O's that will remain as 'O' in the result.
 * After BFS, there are some 'O's can not be reached, they are the 'O's that need to be turned as 'X'.
 * Time Comlexity:
**/
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int column = board[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<Point>();
        //Step1. find all 'O's on the edge
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Point(i, 0));
                board[i][0] = '*';
            }
            if (board[i][column - 1] == 'O') {
                queue.offer(new Point(i, column - 1));
                board[i][column - 1] = '*';
            }
        }
        
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Point(0, i));
                board[0][i] = '*';
            }
            if (board[row - 1][i] == 'O') {
                queue.offer(new Point(row - 1, i));
                board[row - 1][i] = '*';
            }
        }
        //Step2. do BFS to the 'O's on the edges
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int r = curPoint.x;
            int c = curPoint.y;                  
            for (int[] dir: dirs) {
                if (r + dir[0] >= 0 && r + dir[0] < row && c + dir[1] >= 0 && c + dir[1] < column && board[r + dir[0]][c + dir[1]] == 'O') {
                    queue.offer(new Point(r + dir[0], c + dir[1]));
                    board[r + dir[0]][c + dir[1]] = '*'; 
                }
            }
        }
        //Step3. change all '*'s to 'O's, all 'O's to 'X's
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {          
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
        
    }
}