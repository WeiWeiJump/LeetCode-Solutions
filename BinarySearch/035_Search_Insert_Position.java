/**
 * Name: Search Insert Position
 * Number: 35
 * Tag: Binary Search
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public int searchInsert(int[] nums, int target) {
        //to find the last position of the range
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] < target) {
            return nums.length;
        }
        if (nums[start] >= target) {
            return start;
        }
        return end;
    }
}