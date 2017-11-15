/**
 * Name: Remove Duplicates from Sorted Array II
 * Number: 80
 * Tag: 2 pointers
 * Main Points:
   we need a count variable to keep how many times the duplicated element appears, 
   if we encounter a different element, just set counter to 1, 
   if we encounter a duplicated one, we need to check this count, 
   if it is already k, then we need to skip it, otherwise, we can keep this element
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int slow = 1, fast = 1, count = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                if (count < 2) {
                    nums[slow++] = nums[fast++];
                    count++; 
                } else {
                    fast++;
                }
            } else {
                count = 1;
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}