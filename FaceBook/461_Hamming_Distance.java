/**
 * Name: Hamming Distance
 * Number: 461
 * Tag: bit manipulation
 * Main Points:count the bit(== 1) of x ^ y
 * Time Complexity: O(31)
 * Space Complexity: O(1)
**/
class Solution {
    public int hammingDistance(int x, int y) {
        //return Integer.bitCount(x ^ y);
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}