/**
 * Name: Length of Last Word
 * Number: 58
 * Tag: String
 * Main Point: first, we remove all the spaces at the end of the string, and then count the len of last word
 * Time Complexity: O(s.length())
 * Space Complexity: O(1) 
**/
class Solution {
    public int lengthOfLastWord(String s) {
        int tail = s.length() - 1, len = 0;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            tail--;
        }
        while (tail >= 0 && s.charAt(tail) != ' ') {
            tail--;
            len++;
        }
        return len;
    }
}