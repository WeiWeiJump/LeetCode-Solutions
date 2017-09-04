/**
 * Name: Reverse Words in a String
 * Number: 151
 * Tag: String
 * Time Complexity: O(s.length)
 * Space Complexity: O(s.length)
**/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = words.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]).append(" ");
            }     
        }
        // remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}