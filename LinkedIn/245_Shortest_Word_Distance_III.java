/**
 * Main Points: 
 index1 and index2 are the indexes where word1 and word2 were last seen. 
 Except if they're the same word, then index1 is the previous index.
 * Time Complexity: average O(n) n = words.length
 * Space Complexity: O(1)
**/
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    index1 = index2;
                }  
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }
        return distance;
    }
}