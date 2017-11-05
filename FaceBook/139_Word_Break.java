/**
 * Name: Word Break
 * Number: 139
 * Tag: DP
 * Time Complexity: O(n^2) n is s.length
 * Space Complexity: O(nk) k is number of string
**/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        //dp[i] represent whether the substring containing first i chars of s can be broken
        boolean[] dp = new boolean[s.length() + 1];
        
        //initializa
        dp[0] = true;
        
        //get the maxlength of the word in the dict to shrink the search range
        int maxLength = 0;
        for(String t : wordDict){
            maxLength = Math.max(maxLength, t.length());
        }
        
        //formula
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        
        return dp[s.length()];
    }
}