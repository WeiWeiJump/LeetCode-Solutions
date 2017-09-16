/**
 * Name: Longest Increasing Subsequence
 * Number: 300
 * Tag: DP/binary search
 * Main Point:
   Method1: 常规DP (deifnition: dp[i]表示以nums[i]结尾的Increasing subsequence的长度-dp[i] means the lenth of a increasing subsequence ending up with nums[i], initialize: dp[i] is at least 1, formula: if nums[j] < nums[i] (0<=j<i) , then update dp[i] to be max(dp[j] + 1, dp[i]))
   Method2: (tricky) tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
  len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
  len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
  len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
Each time we only do one of the two:
(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i] 
 * Time Complexity: Method1-O(n^2) Method2-O(nlogn)
 * Space Complexity: O(n)
**/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //def: dp[i] represents the lenth of a increasing subsequence ending up with nums[i]
        int[] dp =new int[nums.length]; 
        int max = 1;
        //initialize
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        //formula
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);    
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;       
    }
}

/***************Tricky: Tails DP + binary search*********************/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //def: tail[i] represents the smallest tail of all increasing subsequences with length i+1
        int[] tails = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int index = Arrays.binarySearch(tails, 0, len, n);
            //Arrays.binarySearch() returns ( - insertion_index - 1) in cases where the element was not found in the array.
            if (index < 0) index = -(index + 1);
            tails[index] = n;
            if (index == len) len++;
        }
        return len;       
    }
}