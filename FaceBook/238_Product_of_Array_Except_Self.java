/**
 * Name: Product of Array Except Self
 * Number: 238
 * Tag: tricky
 * Main Points: 
   iterate from left to right, multiply all numbers at left of this position
   then iterate from right to left, multiply all numbers at right of this position, mul together
   eg: 1 2 3 4
   first iteration: (left)- 1 1 2 6
   second iteration: (right)- 24 12 4 1    
   final array we get: (mul)- 24 12 8 6
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return new int[0];
        int[] res = new int[nums.length];
        
        //get left array, store it in res
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //then get right half, multiply with left, store in res
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}