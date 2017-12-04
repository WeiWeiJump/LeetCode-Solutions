/**
 * Main Points: Sliding Window
   DABCCBA
   AABBCCBA
   AABC
   1. Use two pointers: start and end to represent a window.
   2. Move end to find a valid window.
   3. When a valid window is found, move start to find a smaller window.
 * Time Complexity: O(n)
 * Space Complexity: O(256)
**/
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int slow = 0, fast = 0;
        int count = t.length();
        int startIdx = 0;
        int minLen = Integer.MAX_VALUE;
        for (; slow < s.length(); slow++) {
            while (fast < s.length() && count > 0) {
                char c = s.charAt(fast++);
                map[c]--;
                if (map[c] >= 0) count--; //if map[c] < 0 表示c不在t中
            }
            //jump out of while
            //record current valid window to see whether it cen update minLen
            if (count == 0) {
                if (fast - slow < minLen) {
                    startIdx = slow;
                    minLen = fast - slow;
                }
                if (minLen == t.length()) {
                    return s.substring(startIdx, startIdx + minLen);
                }
            }
            // When we found a valid window, move start to find smaller window
            //slow is going to increase 1 in next loop
            //we should restore map[cSlow] by add 1 back     
            char cSlow = s.charAt(slow);
            map[cSlow]++;
            if (map[cSlow] > 0) {
                count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}