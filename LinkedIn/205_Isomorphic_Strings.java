/**
 * Main Points:
   The main idea is to store the last seen positions of current (i-th) characters in both strings. 
   If previously stored positions are different then we know that they're not occuring in the current i-th position simultaneously
 * Time Complexity: O(n) n = length of the string
 * Space Complexity: O(512)
**/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() != t.length()) return false;
        
        int[] posOfS = new int[256], posOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (posOfS[s.charAt(i)] != posOfT[t.charAt(i)]) return false;
            posOfS[s.charAt(i)] = posOfT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}