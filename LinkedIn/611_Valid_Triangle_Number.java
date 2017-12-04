/**
 * Main Points: 
 Assume a is the longest edge, b and c are shorter ones, to form a triangle, 
 they need to satisfy len(b) + len(c) > len(a)
 this problem can be solved by 3 pointers, like 3 sum
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
**/
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return -1;
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left; // because if we fix i, fix right, left can be all from original left to right
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}