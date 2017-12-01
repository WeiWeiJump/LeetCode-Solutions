class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            }
        }
        if (nums[start] == target) {
            first = start;
        } else if (nums[end] == target) {
            first = end;
        } 
        
        int second = -1;
        start = 0;
        end = nums.length - 1;
        while (start + 1< end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        if (nums[end] == target) {
            second = end;
        } else if (nums[start] == target) {
            second = start;
        }
        return new int[]{first, second};
    }
}