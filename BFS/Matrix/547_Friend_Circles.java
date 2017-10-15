/**
 * Name: Friend Circles
 * Number: 547
 * Tag: BFS/DFS/Union&Find
 * Main Points: 
   first build adj matrix
   use a visited boolean[] to represent friend that has already be searched
   start from current person, to find all his friends level by level
 * Time Complexity: O(E + V) //edge + vertex (BFS)
                    O(M + N*lg*N) (lg*N can be seen as a number < 5)
                    //Any Sequence of any sequence of M union-find ops on N objs makes <= c (N + M Lg*N) array accesses
 * Space Complexity: O(E + V)
**/
/**************************** Union and Find ***************************/
class Solution {
    class UnionFind{
        private int count;
        private int[] sz, parent;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]]; // path compression
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (sz[rootP] < sz[rootQ]) {
                parent[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
            } else {
                parent[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
            }
            count--;
        }
        public int count() {
            return count;
        }   
    }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(M[i][j] == 1) {
                    uf.union(i, j);
                }
            }          
        }
        return uf.count();
    }
}

/********************************  DFS  ********************************/
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }       
        }
        return count;
    }
    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);         
            }
        }
    }
}

/********************************  BFS  ********************************/
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        //build adj matrix
        List<Integer>[] adj = new List[M.length];
        for (int i = 0; i < M.length; i++) {
            adj[i] = new LinkedList<Integer>();
            for (int j = 0; j < M[0].length; j++) {
                if (i == j) continue;
                if (M[i][j] == 1) {
                    adj[i].add(j);
                }        
            }
        }
        //BFS
        boolean[] visited = new boolean[M.length];
        Queue<Integer> queue = new LinkedList<>();
        int countCircle = 0;
        
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;               
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : adj[cur]) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
                countCircle++;
            }   
        }
        return countCircle;
    }
}