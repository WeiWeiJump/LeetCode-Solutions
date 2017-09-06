/**
 * Name: Search for a Range
 * Number: 34
 * Tag: binary search
 * Main Point: use binary search twice, to find the first target and last target
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        //corner case: null
        if (nums == null || nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        // to find the first target
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
        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        } else {
            res[0] = -1;
        }
        // to find the last target
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            res[1] = end;
        } else if (nums[start] == target) {
            res[1] = start;
        } else {
            res[1] = -1;
        }
        return res;
    }
}