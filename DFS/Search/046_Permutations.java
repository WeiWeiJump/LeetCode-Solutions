/**
 * Name: Permutations
 * Number: 46
 * Tag: DFS/Search
 * Main Points: 
    1. build recursion tree
    2. in order to avoid the element that already appeared in permutation
       use LinkedList.contains() method
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        dfsHelper(nums, permutation, res);
        return res;
    }
    //1. 找到所有以permutation里存的东西开头的排列 
    private void dfsHelper(int[] nums, List<Integer> permutation, List res) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            dfsHelper(nums, permutation, res);
            permutation.remove(permutation.size() - 1);
        }
    }
}