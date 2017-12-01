/**
 * Main Points: binary search
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int start = 0, end = num;
        while(start + 1 < end) {
            long mid = (start + end) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = (int) mid;
            } else {
                end = (int) mid;
            }
        }
        if (start * start == num) {
            return true;
        }
        if (end * end == num) {
            return true;
        }
        return false;
    }
}