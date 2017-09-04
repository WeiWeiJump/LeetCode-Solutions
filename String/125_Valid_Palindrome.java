/**
 * Name: Valid Palindrome
 * Number: 125
 * Tag: String/Two Pointers
 * Time Comlexity: O(s.length)
 * Space Complexity: O(1)
**/
class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int start = 0, end = len - 1; start <= end; start++, end--) {
            while (start < len && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } 
            if (start < len && end >= 0 && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
        }
        return true;
    }
}