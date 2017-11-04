/**
 * Name: Decode Ways
 * Number: 91
 * Tag: DP
 * Main Points:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        //dp[i]表示字符串s的前i个char的decode ways
        int[] dp = new int[s.length() + 1];
        
        //initialize
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        //formula
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];  
            }
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}