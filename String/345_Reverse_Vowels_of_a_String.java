/**
 * Name: Reverse Vowels of a String
 * Number: 345
 * Tag: String/Two Pointers
 * Time Complexity: O(s.length)
 * Space Complexity: O(s.length)
**/
class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int start = 0, end = len - 1;
        while (start < end) {
            while (start < len && !isVowel(chars[start])) {
                start++;
            }
            while (end >= 0 && !isVowel(chars[end])) {
                end--;
            }
            if (start < end && isVowel(chars[start]) && isVowel(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
            }
            start++;
            end--;
        }
        return new String(chars);
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}