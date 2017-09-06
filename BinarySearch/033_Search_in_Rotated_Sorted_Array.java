/**
 * Name: Search in Rotated Sorted Array
 * Number: 33
 * Tag: Binary Search
 * Main Point: rotated array特性图
 * Time Complexity: O(logn)
 * Space Xomplexity: O(1)
**/
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums == null || nums.length == 0) return -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } // else
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }         
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}