/**
 * Name: Longest Palindromic Substring
 * Number: 5
 * Tag: DP
 * Idea: dp(i, j)) represents whether s(i,j) is palindromic, check each palindromic substring, record the max length
 * Time Comlplexity: O(n ^ 2)
 * Space Comlexity: O(n ^ 2)[DP] O(1)[Tow Pointers]
**/

/** DP VERSION**/
public class Solution {
    public String longestPalindrome(String s) {
        String res = null;
        if (s == null || s.length() == 0) return res;
        int len = s.length();
        //definition: dp[i][j] represents whether s(i,j) is palindromic (j >= i)
        boolean[][] dp = new boolean[len][len];
        
        //formula
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                //for each palindromic substring, save the maxLenth
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }      
            }
        }
        //result
        return res;
    }
}

/** Two Pointers VERSION **/
public class Solution {
    private int start, maxLen;
    public String longestPalindrome(String s) {
       if (s == null || s.length() == 0) return null;
       
       for (int i = 0; i < s.length(); i++) {
           extendPalindrome(s, i, i); //Odd: treat s.chatAt(i) as a center, try to extend Palindrome from the center
           extendPalindrome(s, i, i + 1); // Even: treat s.chatAt(i, i + 1) as a center
       }
       return s.substring(start, start + maxLen);
    }
    private void extendPalindrome(String s, int centerStart, int centerEnd) {
        while (centerStart >= 0 && centerEnd < s.length() && s.charAt(centerStart) == s.charAt(centerEnd)) {
            centerStart--;
            centerEnd++;
        }
        if (maxLen < centerEnd - centerStart - 1) {
            maxLen = centerEnd - centerStart - 1;
            start = centerStart + 1;
            //end = centerEnd - 1;
        }
    }
}