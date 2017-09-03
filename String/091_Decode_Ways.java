/**
 * Name: Decode Ways
 * Number: 91
 * Tag: DP/String
 * Main Point: p[i] represent the number of ways to decode s.substring(0, j); 
   two cases: 
   if s(i) != 0, then s(i) can be decoded just by this digit alone
   // if s(i-1, i) is between (10, 26), then s(i) can be decoded together with the digit before it
 * Time Complexity: O(s.length());
 * Space Complexity: O(s.length());
**/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        //def: dp[i] represent the number of ways to decode s.substring(0, j);
        int len = s.length();
        int[] dp = new int[len + 1];
        //initialize
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        //formula
        for (int i = 2; i <= len; i++) {       
            //if s(i) != 0, then s(i) can be decoded just by this digit alone
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            } 
            // if s(i-1, i) is between (10, 26), then s(i) can be decoded together with the digit before it 
            int two_digits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (two_digits >= 10 && two_digits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}

/**
 * Improvement: dp[i] only relies on dp[i - 1] and dp[i - 2],
   so we just need two variables to record dp[i - 1] and dp[i - 2]
 * Time Complexity: O(s.length)
 * Space Complexity: O(1)
**/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        //def: dp[i] represent the number of ways to decode s.substring(0, j);
        int len = s.length();
        //int[] dp = new int[len + 1];
        //initialize
        int dp_llast = 1;
        int dp_last = s.charAt(0) != '0' ? 1 : 0;
        int dp_now = dp_last;
        //formula
        for (int i = 2; i <= len; i++) { 
            dp_now = 0;
            //if s(i) != 0, then s(i) can be decoded just by this digit alone
            if (s.charAt(i - 1) != '0') {
                dp_now = dp_last;
            } 
            // if s(i-1, i) is between (10, 26), then s(i) can be decoded together with the digit before it 
            int two_digits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (two_digits >= 10 && two_digits <= 26) {
                dp_now += dp_llast;
            }
            dp_llast = dp_last;
            dp_last = dp_now;
        }
        return dp_now;
    }
}