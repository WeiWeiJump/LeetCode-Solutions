/**
 * Name: Excel Sheet Column Title
 * Number: 168
 * Main Points: turn a integer to 26-based number
 * Time Complexity: O(log26 n)
 * Space Complexity: O(log26 n)
**/
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}