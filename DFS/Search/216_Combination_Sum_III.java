/**
 * Name: Combination Sum III
 * Number: 216
 * Tag: DFS/backtracking
 * Main Points: build recursion tree
 * Time Comlexity: O(C9 k) (排列组合符号)
 * Space Complexity: O(k)
**/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) {
            res.add(combination);
            return res;
        }
        sumHelper(k, n, 1, combination, res);
        return res;
    }
    private void sumHelper(int k, int target, int startPos, List<Integer> combination, List<List<Integer>> res) {
        if (combination.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(combination));
                return;
            } else {
                return;
            }
        }       
        for (int i = startPos; i <= 9; i++) {
            combination.add(i);
            sumHelper(k, target - i, i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}