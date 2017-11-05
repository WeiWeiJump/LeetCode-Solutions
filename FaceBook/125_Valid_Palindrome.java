/**
 * Name: Valid Palindrome
 * Number: 125
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++; end--;
            }               
        }                     
        return true;
    }
}