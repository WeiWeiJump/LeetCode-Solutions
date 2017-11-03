/**
 * Name: Implement strStr()
 * Number: 28
 * Tag: Array
 * Main Points: 
   Returns a index to the first occurrence of target(needle) in source(haystack), 
   or -1  if target is not part of source.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
**/
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for ( ; j < needle.length(); j++)  {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            //finish loop, found i
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}