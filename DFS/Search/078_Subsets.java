/**
 * Name: Subsets
 * Number: 78
 * Tag: DFS/BackTracking
 * Main Points: 
   1. build recursion tree
   2. you will find er never visited the node before current node
      so use a position as parameter, transferring to next level
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }
        List<Integer> subset = new ArrayList<>();
        dfsHelper(nums, subset, subsets, 0);
        return subsets;
    }
    private void dfsHelper(int[] nums, List subset, List subsets, int pos) {
        subsets.add(new ArrayList<Integer>(subset));
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            dfsHelper(nums, subset, subsets, i + 1);
            subset.remove(subset.size() - 1);
        }     
    }
}