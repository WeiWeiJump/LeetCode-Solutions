/**
 * Main Points: 
   to proof: shuffle's result: Each number has equal probability to be at any position
   is to proof: for each position j (starting from 0), the probability of any number in the range[0,j] to be at position j is 1/(1+j)
   数学归纳法(mathematical induction)
   1.base case, when j = 0, there is just one number, the probability is 1/1 
   2. assume it works for j - 1, we need to prove when j, the probability of any number in the range[0,j] to be at position j is 1/(1+j)
   Let's look at int i = random.nextInt(j + 1):
   (1) If i == j, nums[j] does not need to change its position, which has probability 1/(1+j).
   (2) if i != j, nums[j] needs to be swapped with nums[i]. 
   The probability of any number x in the range [0,j-1] to be at position j = nums[j] changes its position * x is at position i
= (1-1/(1+j)) * (1/j) = 1/(1+j)
 * Time Complexity:  shuffle O(n)
 * Space Complexity: 
**/
class Solution {
    int[] numbers;
    Random random;
    public Solution(int[] nums) {
        numbers = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return numbers;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = numbers.clone();
        for (int j = 1; j < copy.length; j++) {
            int i = random.nextInt(j + 1);
            swap(copy, i, j);
        }
        return copy;
    }
    void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */