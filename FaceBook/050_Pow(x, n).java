/**
 * Name: Pow(x, n)
 * Number: 50
 * Tag: DFS
 * Main Points: 
   brute force answer: TC O(n)
   recursion answer: O(logn)
   we choose to use recursion
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
**/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) { //很容易错
            n = -(n + 1);
            x = 1/x;
            return x * x * myPow(x * x, n / 2);
        }
        if (n < 0) {
            x = 1/x;
            //we can not write n = -n if n = Integer.Min_VALUE,
            //which will cause an overflow
            n = -n; 
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}