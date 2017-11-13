/**
 * Name: Continuous Subarray Sum
 * Number: 523
 * Tag: HashMap
 * Main Points:
  We iterate through the input array exactly once, 
  keeping track of the running sum mod k of the elements in the process. 
  If we find that a running sum value at index j has been previously seen before 
  in some earlier index i in the array, 
  then we know that the sub-array (i,j] contains a desired sum.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];      
            if (k != 0) {
                runningSum %= k;
            }
            if (map.containsKey(runningSum)) {
                if (i - map.get(runningSum) > 1) return true;
            } else {
                map.put(runningSum, i); 
            }
            
        }
        return false;
    }
}