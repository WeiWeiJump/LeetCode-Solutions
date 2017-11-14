/**
 * Name: Random Pick Index
 * Number: 398
 * Tag: Reservoir Sampling
 * Main Points:
   For the nth target, ++count is n. 
   Then the probability that rnd.nextInt(++count)==0 is 1/n. 
   Thus, the probability that return nth target is 1/n.
   For (n-1)th target, the probability of returning it is (n-1)/n * 1/(n-1)= 1/n.            
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    int[] nums;
    Random rnd;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int res = 0;
        int count = 0; // count means nth target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            
            if (rnd.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */