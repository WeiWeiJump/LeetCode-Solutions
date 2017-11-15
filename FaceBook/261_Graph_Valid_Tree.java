/**
 * Name: Graph Valid Tree
 * Number: 261
 * Tag: Union Find/BFS
**/
/**
 * Main Points: 
   Union Find:
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
**/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        //initialize each node to be disconnected
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int[] edge : edges) {
            int rootX = find(nums, edge[0]);
            int rootY = find(nums, edge[1]);
            
            //if two vertices happen to be in the same set
            // then there's a cycle
            if (rootX == rootY) return false;
            
            //union 
            nums[rootX] = rootY;
        }
        
        return true;
    }
    public int find(int[] nums, int node) {
        if (nums[node] == -1) return node;
        return find(nums, nums[node]);
    }
}

/**
 * Main Points: 
   BFS: 
   use a set to store the node that has been visited
   after we visit current node and plan to visit its neighbor
   we cut off the path from its neighbor back to this node
   if we can still travel to this node again, it means there's a loop
 * Time Complexity: O(V*E)
 * Space Complexity: O(V)
**/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1) return false; 
        if (edges == null) return false;
        
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        //build adj list
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited.contains(cur)) {
                return false;
            }
            visited.add(cur);
            for (int next : map.get(cur)) {
                queue.offer(next);
                map.get(next).remove(cur);
            }
        }
        
        return visited.size() == n;
    }
}
