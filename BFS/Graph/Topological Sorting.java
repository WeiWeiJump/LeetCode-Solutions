/**
 * Topological Sorting 
 * Sample (REMENBER STEP 1 2 3)
 * Time Complexity: O(V + E) (V: number of nodes E: number of edges)
**/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if (graph == null) return res;
        
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        //step1.calculate the indegree of all nodes
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        //step2.put all 0-indegree nodes into the queue as initialization
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node: graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }
        //step3.delete current node and its edges
        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode neighbor: curNode.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;
    }
}