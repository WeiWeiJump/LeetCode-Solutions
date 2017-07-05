/**
 * Name: Minimum Height Trees
 * Number: 310
 * Tag: BFS
 * Time & Space Complexity: O(n)
 * Idea: 
 * First we can think about a simple case -- a path graph£ºSuppose we don't know n, nor do we have random access of the nodes. We have to traversal. It is very easy to get the idea of two pointers. One from each end and move at the same speed. When they meet or they are one step away, (depends on the parity of n), we have the roots we want.
 * For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves). We let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two pointers meet or one step away we then find the roots. It is easy to see that the last two pointers are from the two ends of the longest path in the graph.
 * The actual implementation is similar to the BFS topological sort. Remove the leaves, update the degrees of inner vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!
 * Note that for a tree we always have V = n, E = n-1, So the time complexity and space complexity are both O(n).
**/
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) return null;
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj = new ArrayList<>();
        /*creat adjacent matrix*/
        for (int i = 0; i < n; i++) adj.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        /*add all leaves to a queue*/
        Queue<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.offer(i);
            }
        }
        /*remove all leaves by BFS until only one or two left*/
        while (n > 2) {
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int leave = leaves.poll();
                int neighbor = adj.get(leave).iterator().next();
                adj.get(neighbor).remove(leave);
                if (adj.get(neighbor).size() == 1) {
                    leaves.add(neighbor);
                }
            }
            n -= size;
        }
        return new LinkedList<Integer>(leaves);
    }
}