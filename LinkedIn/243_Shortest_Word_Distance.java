/**
 * Main Points: iterate whole array, search for word1 and word2 and record their latest position
   keep updating min distance
 * Time Complexity: O(n) n = words.length
 * Space Complexity: O(1)
**/
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    distance = Math.min(distance, Math.abs(index1 - index2));
                }
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    distance = Math.min(distance, Math.abs(index1 - index2));
                }
            }
        }
        return distance;
    }
}