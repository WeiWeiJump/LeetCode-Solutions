/**
 * Name: Two Sum
 * Number: 1
 * Tag: Array
 * Main Points: use a hashmap to store
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
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