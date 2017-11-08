/**
 * Name: Maximum Size Subarray Sum Equals k
 * Number: 325
 * Tag: HashMap
 * Main Points: use sum before index i (contains i) as key, i as value, w
   hen we iterate the array, look up sum - k in the map,
   if found, update maxLen
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int result = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //when sum[i] = target, we need to return i + 1
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            } 
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            //if map containsKey(sum), indicates there must be a index < i, that has equal sum with sum[i]
        }
        return result;
    }
}