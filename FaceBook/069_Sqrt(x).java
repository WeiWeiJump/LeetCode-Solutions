/**
 * Name: Sqrt(x)
 * Number: 69
 * Tag: Binary Search
 * Main Points: from 0 to x, find the last int t that is less than x
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int start = 0, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //find last int that whose square is less than x
        if (end <= x / end) {
            return end;
        } else if (start <= x / start) {
            return start;
        } else {
            return -1;
        }
        
    }
}