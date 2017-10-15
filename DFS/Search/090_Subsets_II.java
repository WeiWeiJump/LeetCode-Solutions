/**
 * Name: Subsets II
 * Number: 90
 * Tag: DFS
 * Main Points:
   basically same idea as subsets
   but we can visit and only visit the first duplicated node
 * Time Complexity: ?
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfsHelper(nums, subset, subsets, 0);
        return subsets;
    }
    private void dfsHelper(int[] nums, List subset, List subsets, int pos) {
        subsets.add(new ArrayList<Integer>(subset));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(nums, subset, subsets, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}