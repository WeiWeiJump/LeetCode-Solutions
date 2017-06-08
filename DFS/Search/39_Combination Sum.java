/**Name: Combination Sum
 * Number: 39
 * Tag: DFS/Backtracking
 * Root: Subsets (without dup)
 * Time Comlexity: O(2^n)
**/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        DFSHelper(candidates, 0, res, combination, target);
        return res;
    }
    private void DFSHelper(int[] candidates, int pos, List<List<Integer>> res, List<Integer> combination, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            DFSHelper(candidates, i, res, combination, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }                       
    }
}