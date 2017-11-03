/**
 * Name: Search in Rotated Sorted Array
 * Number: 33
 * Tag: Binary Search
 * Main Points: 
   binary search
   draw characteristic graph
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else  {
                    end = mid;
                }
            } else {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
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