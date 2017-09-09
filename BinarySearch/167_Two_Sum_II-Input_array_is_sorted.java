/**
 * Name: Two Sum II - Input array is sorted
 * Number: 167
 * Tag: Binary Search
 * Main Point: for each number in numbers, using basic binary search to find (target - number) in the range larger than it. 
               When number is already exceed target, stop searching.
 * Time Comlexity: worse: O(nlogn)
 * Space Comlexity: O(1)
**/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) return res;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                break;
            }
            int start = i, end = numbers.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == target - numbers[i]) { // found
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if (numbers[mid] < target - numbers[i]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (start > i && numbers[i] + numbers[start] == target) {
                res[0] = i + 1;
                res[1] = start + 1;
                return res; //found
            }
            if (end > i && numbers[i] + numbers[end] == target) {
                res[0] = i + 1;
                res[1] = end + 1;
                return res; //found
            }
        }
        //not found
        return res;
    }
    
}