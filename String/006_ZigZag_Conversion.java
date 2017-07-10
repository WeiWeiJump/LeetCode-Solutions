/**
 * Name: ZigZag Conversion
 * Number: 6
 * Tag: String
 * Time Comlexity: O(s.length() + numRows)
 * Space Comlexity: O(s.length())
 * Idea: Create nRows StringBuffers, and keep collecting characters from original string to corresponding StringBuffer. 
**/
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        if (numRows <= 0) return null; 
        
        StringBuffer[] display = new StringBuffer[numRows];
        int numChar = 0;
        for (int i = 0; i < numRows; i++) {
            display[i] = new StringBuffer();
        }
        while (numChar < s.length()) {
            for (int idx = 0; idx < numRows && numChar < s.length(); idx++) {
                display[idx].append(s.charAt(numChar++));
            }
            for (int idx = numRows - 2; idx > 0 && numChar < s.length(); idx--) {
                display[idx].append(s.charAt(numChar++));
            }
        }
        for (int i = 1; i < numRows; i++) {
            display[0].append(display[i]);
        }
        return display[0].toString();
    }
}