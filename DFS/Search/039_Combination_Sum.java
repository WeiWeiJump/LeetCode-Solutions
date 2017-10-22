/**
 * Name: Combination Sum
 * Number: 039
 * Tag: DFS
 * Main Points: build recursion tree, pay attention to what information should be conveyed to next level
 * Time Comlexity:
 * Space Complexity:
**/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> combination = new ArrayList<>();
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
            combination.add(candidates[i]);
            sumHelper(candidates, target - candidates[i], i, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}