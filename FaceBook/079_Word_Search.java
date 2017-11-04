/**
 * Name: Word Search
 * Number: 79
 * Tag: DFS
 * Main Points: pay attention to reset visited flag
 * Time Complexity: O(m*n*4^min(m*n, word.length))
 * Space Complexity: O(board.length * board[0].length)
**/
class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        //here can be improved, we needn't to use visited matrix
        //to save this place, we can use board[x][y] += 256, to turn board[x][y] to go out of the range of ASCII
        //since bit manipulation is faster, we can use board[x][y] ^= 256 when we need to set visited
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {  
                if (explore(board, word, visited, 0, i, j)){
                    return true;
                }           
            }
        }
        return false;
    }
    //explore returns whether we can find target string(word.substring(pos)) with the start point (x, y) 
    private boolean explore(char[][] board, String word, boolean[][] visited, int pos, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(pos)) return false;
        if (pos == word.length() - 1 && board[x][y] == word.charAt(pos)) return true;
        
        visited[x][y] = true; 
        // board[x][y] ^= 256; to turn board[x][y] an invalid symbol
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];        
            if(explore(board, word, visited, pos + 1, nextX, nextY)) {
                return true;
            }    
        }
        //when backtracking, reset visited flag 
        visited[x][y] = false;
        // board[x][y] ^= 256 to turn board[x][y] back
        return false;      
    }
}