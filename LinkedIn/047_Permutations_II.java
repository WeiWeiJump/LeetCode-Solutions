//             null  1,1,2
//   1 | 1,2      1******       2 | 1,1  
// 1,1 | 2    1,2 | 1     2,1 | 1      2,1***
// 1,1,2      1,2,1       2,1,1
/**
 * Main Points: we can avoid using set to avoid duplicates by following the rule that
   first we sort the array (eg. 1,2,1 -> 1,1,2)
   we will not visit second 1 if we didn't visit first 1
 * Time Complexity: O(n!)
 * Space Complexity: O(nums.length)
**/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) return permutations;
        
        boolean[] visited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(nums, permutation, permutations, visited);
        return permutations;
    }
    private void permuteHelper(int[] nums, List<Integer> permutation, List<List<Integer>> permutations, boolean[] visited) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
            visited[i] = true;
            permutation.add(nums[i]);
            permuteHelper(nums, permutation, permutations, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}