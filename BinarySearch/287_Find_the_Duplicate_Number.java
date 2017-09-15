/**
 * Name: Find the Duplicate Number
 * Number: 287
 * Tag: Binary Seach
 * Main Point: using binary search in nums' value domain, not its index.
   count the number of nums that are no more than mid value, eg. 1 2 2 3 4 5 6 7 8, mid value is (1+8)/2 = 4, if count(the nums that are no more than 4) <= 4, it indicates that the numbers that are no more than 4 has no duplicate, because the boundry case is from 1 to 4.
 * Time Complexity: O(n*logn)
 * Space Complexity: O(1)
**/

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        int start = 1, end = nums.length;
        while (start < end) {
            int count = 0;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

/**
 * Tag: 2 pointers
 * Main Point: (dirty trick) like the picture about linkedlist cycle. we construct a linkedlist that index -> value, then take value as index, to sind the next value. For example, 2 3 7 4 5 3 6 1 8, so the linkedlist is 2 -> 7 -> 1 -> 3 -> 4 -> 5 -> 3, here comes the loop like cycled linkedlist.
   So first, we initialize the slow pointer at position 0, the fast pointer at position 1, then move slow pointer one step each time; move fast pointer two steps each time. Finally the two pointers meet inside the circle, at that time the distance of pointers to the entrance of the circle is equal to that of the start point to the entrance of the circle.
**/

/**************************Triky Way*****************************/
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

