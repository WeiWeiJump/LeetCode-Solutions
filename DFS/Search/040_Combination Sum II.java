/**Name: Combination Sum II
 * Number: 40
 * Tag: DFS/Backtracking
 * Root: Subsets (with dup)
 * Time Complexity: O(2^n)
 * Advance: reverse order 
**/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        DFSHelper(candidates, candidates.length - 1, combination, res, target);
        return res;
    }
    private void DFSHelper(int[] candidates, int pos, List<Integer> combination, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        if (target < 0) return;
        for (int i = pos; i >= 0; i--) {
            if (i != pos && candidates[i] == candidates[i + 1]) {
                continue;
            }
            combination.add(candidates[i]);
            DFSHelper(candidates, i - 1, combination, res, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}