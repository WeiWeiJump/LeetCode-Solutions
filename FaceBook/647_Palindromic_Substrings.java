/**
 * Name: Palindromic Substrings
 * Number: 647
 * Tag: extend palindrome
 * Main Points: extend palindrome
 * Time Complexity: O(n ^ 2) "aaaaaaa.....aaaaaaa"
 * Space Complexity: O(1)
**/
class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;    
        //running mid
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i); //odd length
            extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }
    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}