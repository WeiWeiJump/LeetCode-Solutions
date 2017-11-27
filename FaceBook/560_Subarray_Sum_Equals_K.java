/**
 * Name: Subarray Sum Equals K
 * Number: 560
 * Tag: hashmap
 * Main Points: 
   the key to solve this problem is SUM[i, j]. 
   So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
   To achieve this, we just need to go through the array, 
   calculate the current sum and save number of all seen PreSum to a HashMap.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, count = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}