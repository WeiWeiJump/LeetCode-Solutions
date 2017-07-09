/**
 * Name: Longest Substring Without Repeating Characters
 * Number: 3
 * Tag: Two Pointers/HashMap
 * Idea: keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
 * Time Comlexity: O(n)
 * Space Complexity: O(n)
**/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
                map.put(s.charAt(end), end);
                max = Math.max(max, end - start + 1);
        }
        return max;
    }
}