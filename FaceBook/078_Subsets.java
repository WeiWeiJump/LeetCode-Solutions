/**
 * Name: Subsets
 * Number: 78
 * Tag: DFS/Backtracking
 * Main Points:
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> subset = new ArrayList<>();
        search(nums, 0, subset, res);
        return res;
    }
    private void search(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {     
        res.add(new ArrayList<>(subset));
        //if (pos == nums.length) return;
        
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            search(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}