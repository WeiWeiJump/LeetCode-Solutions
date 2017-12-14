/**
 * Main Points: 3 pointers
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
**/
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int countTriple = 0;
        for (int i = 0; i < nums.length - 2; i++) {    
            int j = i + 1, k = nums.length - 1;
            int newTarget = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] >= newTarget) {
                    k--;
                } else {
                    countTriple += k - j;
                    j++;
                }
            }
        }
        return countTriple;
    }
}