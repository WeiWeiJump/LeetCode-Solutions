/**
 * Name: Palindrome Partioning
 * Number: 131
 * Tag: DFS
 * Main Points:
   1. build recursion tree
   2. time was wasted in decide isPalindrome
   if there is a follow up ask you to improve this solution
   you can use DP to store all the information about ispalindome[i][j]
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        List<String> partition = new ArrayList<>();
        partitionHelper(s, 0, partition, res);
        return res;
    }
    private void partitionHelper(String s, int start, List<String> partition, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(partition));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            if (!isPanlindrome(cur)) {
                continue;
            }
            partition.add(cur);
            partitionHelper(s, i + 1, partition, res);
            partition.remove(partition.size() - 1);
        }
    }
    private boolean isPanlindrome(String cur) {
        for (int start = 0, end = cur.length() - 1; start < end; start++, end--) {
            if (cur.charAt(start) != cur.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}