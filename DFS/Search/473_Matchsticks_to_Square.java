/**Name: Matchsticks to Square
 * Number: 473
 * Tag: DFS/Backtracking
 * Root: Subsets
 * Time Comlexity: O(n!/(n/4)!^4)
 * Analysis: Given N objects, how many ways can you partition then into 4 subsets with each size Nk=1:4? (¦²k=1:4Nk = N)
 * the answer is N!/(N1!N2!N3!N4!). 
 * Note that for fixed N, the denominator achieves minimum if all Nk=1:4 are identical, so the worse case is
 * N!/(N1!N2!N3!N4!) ¡Ü N!/(N/4)!4.
**/

public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int sum = 0, count = 0;
        int[] buckets = new int[4];
   
        for (int i : nums) {
            sum += i;
        }
        
        if (sum % 4 != 0) return false;
        
        Arrays.sort(nums);
        return DFS(nums, nums.length - 1, buckets, sum / 4);
    }
    private boolean DFS(int[] nums, int candidate, int[] buckets, int target) {
        if (candidate < 0) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] += nums[candidate];
            if (buckets[i] <= target) {
                if (DFS(nums, candidate - 1, buckets, target)) {
                    return true;
                }
            }
            buckets[i] -= nums[candidate];
        }
        return false;
    }
}