/**
 * Name: Remove Duplicates from Sorted Array
 * Number: 26
 * Tag: Array
 * Main Points: 
   idx: count the length of the array, at the same time serve as a pointer to the elements in new array
   i: fast pointer, keep iterating, when nums[i] is a unique element in the new array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}