/**
 * Main Points: 
   reverse a string, and then reverse each words
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public void reverseWords(char[] str) {
        reverseHelper(str, 0, str.length - 1);
        for (int i = 0, j = 0; i <= str.length; i++) {
            if (i == str.length || str[i] == ' ') {
                reverseHelper(str, j, i - 1);
                j = i + 1;
            }
        }
    }
    private void reverseHelper(char[] str, int start, int end) {
        while (start < end && start >= 0 && end < str.length) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}