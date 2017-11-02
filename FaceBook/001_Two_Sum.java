/**
 * Name: Two Sum
 * Number: 1
 * Tag: Array
 * Main Points: use a hashmap to store
   2 ways come into mind:
   (1) brute force (TC:O(n^2), SC:O(1))
   (3) HashMap (TC: O(n), SC:O(n))
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Follow up: 
   if we need to output the numbers rather than indices
   hashmap works, 2 pointers also works(TC: O(nlogn), SC:O(1))
**/
class Solution {
    /******************** HashMap ********************/
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { //containsKey O(1)
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } 
            map.put(nums[i], i);  //put O(1)          
        }
        return ans;    
    }
    
}