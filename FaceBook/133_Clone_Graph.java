/**
 * Name: Clone Graph
 * Number: 133
 * Tag: BFS
 * Main Points: 
   pay attention to queue.offer(neighbor)
   we can't add sth to queue repeatedly, so we offer(neighbor) under the condition !map.containsKey(neighbor)
 * Time Complexity: O(E + V)
 * Space Complexity: O(V) (queue take up V, map take up V)
**/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, new UndirectedGraphNode(cur.label));
            }
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}