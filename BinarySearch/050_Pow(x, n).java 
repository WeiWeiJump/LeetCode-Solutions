/**
 * Name: Pow(x, n)
 * Number: 50
 * Tag: binarySearch / recursion
 * main point : 3^7 = (3^3)^2 * 3; 3^6 = (3^3)^2
   recursively divide n into n/2, every time calculate (x^n/2) ^ 2, if n is odd, then mutiply x; if n is even, just return it.
 * Time Comlexity: O(logn)
 * Space Comlexity: O(1)
**/
class Solution {
    public double myPow(double x, int n) {       
        if (n < 0) {
            x = 1 / x;
            n = - n;
        }
        return helper(x, n);
    }
    private double helper(double x, int n) {
        if (n == 0) return 1;
        double res = helper(x, n / 2);
        if (n % 2 == 0) return res * res;
        else return res * res * x;
    }
}