/**
 * Name: Valid Perfect Square
 * Number: 36
 * Tag: Binary Search
 * Main Points: from 1 to n, search a number whose square is just n
 * Time Complexity: O(log(num.length));
 * Space Complexity: O(1)
**/
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int start = 1, end = num - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == num / mid && num % mid == 0) { //(mid * mid == num will overflow)
                return true;
            } else if (mid < num / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start == num / start && num % start == 0) {
            return true;
        }
        if (end > 0 && end == num / end && num % end == 0) {
            return true;
        }
        return false;
    }
}