/**
 * Name: 3Sum
 * Number: 15
 * Tag: DFS/BackTracking
 * Main Points:
   //use DFS will lead time complexity to be O(n^3) (Cn3 = n(n-1)(n-2)/6)
   //then we want to decrease the time complexity using 2 pointers.
   //First we sort the array and run through all indices as first possible element of a triplet
   //For each first element, we make a bi-directional 2Sum sweep of the remaing part of the array
   //Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
   //-4 -1 -1 0 1 2
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
**/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //if there is duplicates, we always skip the duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1, end = nums.length - 1, twoSum = 0 - nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        //skip duplicates
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < twoSum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }   
}