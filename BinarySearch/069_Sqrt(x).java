/**
 * Name: Sqrt(x)
 * Number: 69
 * Tag: Binary Search
 * Main Point: search a number s from 1 to x/2, which satisfies s^2 = x
 * Time Complexity: O(logx)
 * Space Complexity: O(1)
**/
class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0 || x == 1) return x;
        int start = 1, end = x / 2;
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
        if (end <= x / end) {
            return end;
        } else {
            return start;
        }            
    }
}