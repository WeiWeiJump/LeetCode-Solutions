/**
 * Main Points: 
 since the n numbers are from [0, n], we can just add all the numbers from [0, n] together 
 and minus the sum of the n-1 numbers in array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        return sum;
    }
}