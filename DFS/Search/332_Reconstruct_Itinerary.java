/**
 * Name: Reconstruct Itinerary
 * Number: 332
 * Tag: DFS
 * Main Points: first build adjacent matrix, then dfs. 
   Inorder to keep elements in adj matrix a acsending order, 
   use priority queue instead of linked list to save elements
 * Time Complexity: O(tickets.length)
 * Space Complexity: O(tickets.length)
**/
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        //first build adj matrix
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        List<String> res = new LinkedList<>();
        String cur = "JFK";
        dfs(cur, map, res);
        Collections.reverse(res);
        return res;
    }
    //dfs helper function
    private void dfs(String cur, HashMap<String, PriorityQueue<String>> map, List res) {              
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {            
            dfs(map.get(cur).poll(), map, res); 
        }         
        res.add(cur);
    }
}