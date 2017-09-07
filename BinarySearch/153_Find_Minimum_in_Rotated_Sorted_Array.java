/**
 * Name: Find Minimum in Rotated Sorted Array
 * Number: 153
 * Tag: Binary Search
 * Main Point: draw rotated array's feature figure.
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
**/
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}