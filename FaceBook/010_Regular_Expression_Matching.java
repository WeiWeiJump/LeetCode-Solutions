/**
 * Name : Regular Expression Matching
 * Number: 10
 * Tag: DP
 * Main Points:
   DP[i][j] represents s的前i个字符能不能match p的前j个字符
   first initialize DP[j][0] = false DP[0][j]的初始化比较复杂 以p: "c*a*." 为例去想
   进一步得到DP数组过程中的情况：
   1. s.charAt(i - 1) == p.charAt(j - 1), dp[i][j] = dp[i - 1][j - 1]
   2. p.cahrAt(j - 1) == '.', dp[i][j] = dp[i - 1][j - 1]
   3. p.charAt(j - 1) == '*', 两种情况：
      (1). p.charAt(j - 2) != s.charAt(i - 1), dp[i][j] = dp[i][j - 2] //a* can only counts as empty
      (2). p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.', then
           dp[i][j] = dp[i][j - 2] // a* counts as empty
        || dp[i][j - 1] // a* counts as single a
        || dp[i - 1][j] // a* counts as multiple a (extend)
 * Time Complexity: O(s.length * p.length)
 * Space Complexity: O(s.length * p.length)
**/
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        //definition: DP[i][j] represents s的前i个字符能不能match p的前j个字符
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //initialize:
        dp[0][0] = true; //dp[i][0] 全为fasle不用初始化
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) { //可以消掉c*
                dp[0][j] = true;
            }
        }
        //get formula
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (dp[i][j]) continue;
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}