/**
 * Name: Generate Parentheses
 * Number: 22
 * Tag: DFS/Backtracking
 * Time Comlexity: O(2^n)
**/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) return res;
        DFSHelper(res, "", 0, 0, n);
        return res;
    }
    private void DFSHelper(List<String> res, String temp, int open, int close, int max) {
        if (temp.length() == max * 2) {
            res.add(temp);
            return;
        }
        if (open < max) {
            DFSHelper(res, temp + '(', open + 1, close, max);
        }
        if (close < open) {
            DFSHelper(res, temp + ')', open, close + 1, max);
        }
    }
}