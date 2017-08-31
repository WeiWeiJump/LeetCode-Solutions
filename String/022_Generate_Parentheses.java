/**
 * Name: Generate Parentheses
 * Number: 22
 * Tag: DFS/Backtracking
 * Time Comlexity: O(2^n)
 * Main Point: Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. How to keep valid: we can only add ‘(’ when the num of ‘(’ < n, we can only add ‘)’ when the num of ‘)’ < ‘(’.
**/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        DFSHelper(new StringBuilder(), res, 0, 0, n);
        return res;
    }
    private void DFSHelper(StringBuilder parenthesis, List res, int left, int right, int n) {
        if (parenthesis.length() == 2 * n) {
            res.add(parenthesis.toString());
            return;
        }
        if (left < n) {
            DFSHelper(parenthesis.append('('), res, left + 1, right, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        } 
        if (right < left) {
            DFSHelper(parenthesis.append(')'), res, left, right + 1, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
    } 
}