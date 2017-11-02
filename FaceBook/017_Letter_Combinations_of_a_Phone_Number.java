/**
 * Name: Letter Combinations of a Phone Number
 * Number: 17
 * Tag: DFS
 * Main Points:
   It's a tipical DFS problem. Use StringBuilder to make appending process faster
   easy to make mistake: digits.charAt(pos)  - '0' (-0' here)
 * Time Complexity: if all corresponding string's length is 3, then it's 3^n
 * Space Complexity: O(n)
**/
class Solution {
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        StringBuilder path = new StringBuilder();
        dfs(digits, 0, path, res);
        return res;
    }
    private void dfs(String digits, int pos, StringBuilder path, List<String> res) {        
        if (pos == digits.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < dict[digits.charAt(pos) - '0'].length(); i++) {
            path.append(dict[digits.charAt(pos)  - '0'].charAt(i));
            dfs(digits, pos + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        
    }
    
}