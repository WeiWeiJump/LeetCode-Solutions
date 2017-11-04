
/******************  2-PASS  *****************/
/* Main Points: bucket sort
 * Time Complexity: O(2n)
 * Space Complexity: O(1)
 */

class Solution {
    public void sortColors(int[] nums) {
        //buckets sort
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        for (int ptr = 0, val = 0; val < 3; val++) {
            for (int j = 0; j < colors[val]; j++) {
                nums[ptr++] = val;
            }
        }
    }
}

/******************  1-PASS  *****************/
/* Main Points: 3-pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void sortColors(int[] nums) {
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0 && i != j) {
                swap(i--, j++, nums);               
            }
            if (nums[i] == 2 && i != k) {
                swap(i--, k--, nums);
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
