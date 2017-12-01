/**
 * Main Points: two pointers
 * Time Complexity: O(sqrt(c))
 * Space Complexity: O(1)
**/
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int start = 0, end = (int)Math.sqrt(c);
        while (start <= end) {
            int cur = start * start + end * end;
            if (cur == c) {
                return true;
            } else if (cur < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}