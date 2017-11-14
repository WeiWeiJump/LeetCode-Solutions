/**
 * Name: Subsets II
 * Number: 90
 * Tag: DFS
 * Main Points: 
   sort and skip duplicate ones
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfsHelper(nums, 0, subset, res);
        return res;
    }
    private void dfsHelper(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    } 
}