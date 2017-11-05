/**
 * Name: Word Ladder
 * Number: 127
 * Tag: BFS
 * Main Points:
 * Time Complexity: O(26mn) m:length from startWord to endWord n: word.length
 * Space Complexity: O(2mn)
**/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return 0;
        if (beginWord.length() != endWord.length()) return 0;
        
        Set<String> dict = new HashSet<String>();
        for (String s : wordList) {
            dict.add(s);
        }
        dict.add(beginWord);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();          
                if (curWord.equals(endWord)) {
                    return count;
                }
                List<String> nexts = AdjList(curWord, dict); 
                for (String next : nexts) {
                    if (!visited.contains(next)) {
                        queue.offer(next);    
                        visited.add(next);
                    }
                }    
            }       
        }
        return 0;
    }
    private List<String> AdjList(String curWord, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curWord.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (curWord.charAt(i) != c) {
                    StringBuilder substitute = new StringBuilder();
                    substitute.append(curWord.substring(0, i)).append(c).append(curWord.substring(i + 1));
                    String extended = substitute.toString();
                    if (dict.contains(extended)) {
                        res.add(extended);
                    }
                }
            }
        }
        return res;
    }
}