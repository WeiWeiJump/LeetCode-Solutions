/**Name: Friend Circle
 * Number: 547
 * Tag£ºDFS
 * Time Complexity: O(n^2)?
 * (you need to explore a triangle(a half of the square))
**/
public class Solution {
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] M, boolean[] visited, int i) { 
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (i == j || M[i][j] == 0) continue;
            dfs(M, visited, j);
        }
    }
}