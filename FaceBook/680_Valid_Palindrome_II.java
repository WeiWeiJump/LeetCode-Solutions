/**
 * Name: Valid Palindrome II
 * Number: 680
 * Tag: 2 pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return palindromeHelper(s, start + 1, end) || palindromeHelper(s, start, end - 1);
            }
            start++; end--;
        }
        return true;
    }
    private boolean palindromeHelper(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    } 
}