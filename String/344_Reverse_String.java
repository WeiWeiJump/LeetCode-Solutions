/**
 * Name: Reverse String
 * Number: 344
 * Tag: String/Reverse
 * Time Complexity: O(s.length)
 * Space: Complexity: O(s.length)
**/
class Solution {
    public String reverseString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp; 
        }
        return new String(chars);
    }
}