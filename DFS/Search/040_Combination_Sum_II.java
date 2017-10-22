/**
 * Name: Combination Sum II
 * Number: 040
 * Tag: dfs/backtracking
 * Main Points:
   build recursion tree
 * Time Complexity: 
 * Space Complexity:
**/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        sumHelper(candidates, target, 0, combination, res);
        return res;
    }
    private void sumHelper(int[] candidates, int target, int startPos, List<Integer> combination, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = startPos; i < candidates.length; i++) {
            if (i > startPos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            sumHelper(candidates, target - candidates[i], i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}