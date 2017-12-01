/**
 * Main Points: 
 Greedily place a flower at every vacant spot encountered from left to right,
 until we place n flowers or go out of bound of the array
 * Time Complexity: O(length) length = flowerbed.length
 * Space Complexity: O(1)
**/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed == null || flowerbed.length == 0) return false;
        
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count == n;
    }
}