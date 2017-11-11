/**
 * Name: Maximum Swap
 * Number: 670
 * Tag: Bucket sort
 * Main Points:
   one pass: record the index of 0~9
   two pass: 
   itetate the char string, at the same time iterate from the end of the buckets array
   if digit j > digits[i] && j's position is behind i, the we swap these two number
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                //j is larger than digits[i], check if j's pos is behind i
                if (buckets[j] > i) {
                    char temp = digits[buckets[j]];
                    digits[buckets[j]] = digits[i];
                    digits[i] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}