/**
 * Name: Divide Two Integers
 * Number: 29
 * Tag: Binary Search
 * Main Point: if we want to calculate 39 / 5, Do 39 - 5, 39 - 10, 39 - 20, 39 - 40 failed,
   then do 19 - 5, 19 - 10, 19- 20 failed, then do 9 - 5, 9 - 10 failed, then we add all the times together.
 * Time Complexity: depends
 * Space Comlexity: O(1)
**/
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        
        while (dvd >= dvs) {
            long temp_dvs = dvs, times = 1;
            while (dvd >= (temp_dvs << 1)) {
                temp_dvs <<= 1;
                times <<= 1;
            }
            dvd -= temp_dvs;
            res += times;
        }
        
        return sign == 1 ? res : -res;
    }
}