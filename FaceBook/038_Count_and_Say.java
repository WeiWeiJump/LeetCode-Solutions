/**
 * Name: Count and Say
 * Number: 38
 * Tag: tricky
 * Main Points: since n's result depend on n-1's, depend on n-2's ....
   so we use prev to record last level's result
   inside each level, we iterate through prev,
   when we meet duplicates ints, we increase count
   when we meet unique ints, we append last count and say's result to cur and reset count and say
   eg:21
   count->1, say->2
   when we iterate to 1, we record 12, and reset count->1, say->2
 * Time Complexity: ?
 * Space Complexity: O(n)
 **/
class Solution {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev = new StringBuilder();
        int count; 
        char say;
        
        for (int i = 1; i < n; i++) {
            prev = cur;
            cur = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    cur.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}