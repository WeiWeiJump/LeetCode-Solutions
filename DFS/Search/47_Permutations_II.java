/**
 * Name: Permutations II
 * Number: 47
 * Tag: DFS/BackTracking
 * Main Points: 
   in permutation I, we use ArrayList.contains() method to avoid visited same int twice
   here, since there is duplications, we use visited[pos] to avoid visited same int twice
   Note that we should perform prune when diplicates accurs (visit and only visit first duplicated node) 
 * Time Comlexity: ?
 * Space Complexity: O(n)
**/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfsHelper(nums, permutation, res, visited);
        return res;
    }
    private void dfsHelper(int[] nums, List<Integer> permutation, List<List<Integer>> res, boolean[] visited) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfsHelper(nums, permutation, res, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;            
        }
    }
}