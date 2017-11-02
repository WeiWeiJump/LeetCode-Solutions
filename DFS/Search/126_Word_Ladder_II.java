/**
 * Name: Word Ladder II
 * Number: 126
 * Tag: DFS + BFS
 * Main Points:
   first, this problem ask us to output all possible solutions, this indicates 
   that we should use DFS. Then how to dfs? we need to use every word's distance
   to the start node to prune the DFS (让DFS不走回头路)
   How to record each node's distance to the start node? BFS
   Also, we need to think about how to construct a graph(adjacent list)
 * Time Complexity: bfs:O(26n) dfs: O(max distance * num of path)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {        
        List<List<String>> res = new ArrayList<>();
        //turn List to Set(if not, contains operation takes O(n))
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        dict.add(beginWord);
        //dict.add(endWord);
        if (!dict.contains(endWord)) return res;
                
        Map<String, List<String>> map = new HashMap<>(); //adjacent list
        Map<String, Integer> distance = new HashMap<>(); 
        
        bfs(beginWord, map, distance, dict);
        List<String> path = new ArrayList<>();
        
        dfs(endWord, beginWord, map, distance, path, res);
        
        return res;
    }
    private void dfs(String cur, String start, 
                     Map<String, List<String>> map, Map<String, Integer> distance, 
                     List<String> path, List<List<String>> res) { 
        path.add(cur);
        if (cur.equals(start)) {
            Collections.reverse(path);
            res.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {      
            for (String next : map.get(cur)) {
                if (distance.containsKey(next) && distance.get(next) == distance.get(cur) - 1) {
                    dfs(next, start, map, distance, path, res);
                }                
            }      
        }
        path.remove(path.size() - 1);
    }
    private void bfs(String start, Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> nexts = expand(cur, dict);
            for (String next : nexts) {
                map.get(cur).add(next);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
    }
    //get cur string's neighbor node
    private List<String> expand(String cur, Set<String> dict) {
        List<String> expansion = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (cur.charAt(i) != j) {
                    //expand
                    StringBuilder sb = new StringBuilder();
                    sb.append(cur.substring(0, i));
                    sb.append(j);
                    sb.append(cur.substring(i + 1));
                    String expanded = sb.toString(); 
                
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
    
    
}