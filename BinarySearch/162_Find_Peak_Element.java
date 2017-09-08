/**
 * Name: Find Peak Element
 * Number: 162
 * Tag: Binary Search
 * Main Point: we know for sure that the when n is close to 0, nums[n] is decreasing,
   and it's the same with the case when n is close to nums.length. 
   To find the peak, we only need to look for a increaing trend of nums[mid].
   The peak is between the decreasing trend and the increasing trend.
 * Time Complexity: O(log(nums.length));
 * Space Complexity: O(1)
**/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1; 
        int start = 0, end = nums.length - 1;
        while (end >= 2 && start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] >= nums[end] ? start : end;
    }
}