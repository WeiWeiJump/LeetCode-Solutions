/**Name: Clone Graph
 * Number: 133
 * Tag: BFS
 * Time Complexity: O(n)
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
        if (node == null) return node;
        
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        //clone nodes and edges
        int start = 0;
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode oldNode = nodes.get(i);
            UndirectedGraphNode newNode = map.get(oldNode);
            for (int j = 0; j < oldNode.neighbors.size(); j++) {
                UndirectedGraphNode oldNeighbor = oldNode.neighbors.get(j);
                if (!map.containsKey(oldNeighbor)) {
                map.put(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                nodes.add(oldNeighbor);
                }
                newNode.neighbors.add(map.get(oldNeighbor));
            }
        }
        
        return map.get(node);
    }
}