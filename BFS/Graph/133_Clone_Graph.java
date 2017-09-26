/**
 * Name: Clone Graph
 * Number: 133
 * Tag: BFS/Graph
 * Main Points: 
   use hashmap to store current node as a key, and its deep copy as value.
   BFS from current node to its neighbor, level by level to connect the deep copied node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                UndirectedGraphNode curNode = queue.poll();
                // clone current node
                if (!map.containsKey(curNode)) {
                    map.put(curNode, new UndirectedGraphNode(curNode.label));
                }
                // clone its neighbors ans the relationship
                for (UndirectedGraphNode neighbor : curNode.neighbors) {       
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                        queue.offer(neighbor);
                    }
                    map.get(curNode).neighbors.add(map.get(neighbor));
                } 
            } 
        }
        return map.get(node);
    }
}