/**
 * Name: Letter Combinations of a Phone Number
 * Number: 17
 * Tag£ºDFS
 * Time Complexity: O(3^n)
**/
public class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        combinationHelper("", digits, 0, res);
        return res;
    }
    private void combinationHelper(String prefix, String digits, int start, List<String> res) {
        if (start >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(start) - '0'];
        for (int i = 0; i < letters.length(); i++) {
             combinationHelper(prefix + letters.charAt(i), digits, start + 1, res);
        }
    }
}