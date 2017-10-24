/**
 * Name: Word Ladder
 * Number: 127
 * Tag: BFS
 * Main Points:
   1. construct adjacent list for each word
   2. BFS
 * Time Complexity: O(word.length)
 * Space Complexity: O(wordList.size())
**/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return 0;
        } 
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.add(beginWord);
        
        int len = 0;
        while (!queue.isEmpty()) {           
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String nextWord : getNext(cur, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return len + 1;
                    }
                    set.add(nextWord);
                    queue.offer(nextWord);
                }   
            }
            
        }
        return 0;
    }
    
    private ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] w = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c < 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                //save original word
                char temp = w[i];
                w[i] = c;
                String replacedWord = new String(w);
                w[i] = temp;
                if (dict.contains(replacedWord)) {
                    res.add(replacedWord);
                }
            }
        }
        return res;
    }
}