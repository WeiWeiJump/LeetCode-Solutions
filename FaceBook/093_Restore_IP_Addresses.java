/**
 * Name: Restore IP Addresses
 * Number: 93
 * Tag: DFS
 * Main Points:
   This question is also a question of using DFS to find all possibilities. 
   Such a string of numbers: 25525511135
   We can divide it, but depending on the nature of the IP, it is obviously impossible to divide some of cases:
   For example, 011.11.11.11, the problem is to 0 at the beginning, not legitimate, directly skipped.
   For example, 257.11.11.11, 257 is greater than the maximum number of 255, illegal, skip directly.
   Then we pass the rest of the string to the next layer, continue to find.
   Until the end we got 4 sections, put this result in our result list.
 * Time Complexity: O(3^4)
 * Space Complexity: O(4)
**/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        restoreHelper(s, res, "", 0, 0);
        return res;
    }
    private void restoreHelper(String s, List<String> res, String restored, int pos, int sec) {
        if (s.length() - pos > 3 * (4 - sec)) return;
        if (sec == 4 && pos == s.length()) {
            res.add(restored);
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) return;
            String part = s.substring(pos, pos + i);
            if (part.length() > 1 && part.startsWith("0") || i == 3 && Integer.valueOf(part) >= 256) continue;
            restoreHelper(s, res, sec == 0 ? part : restored + "." + part, pos + i, sec + 1);
        }
    }
}