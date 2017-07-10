/**
 * Name: Longest Common Prefix
 * Number: 14
 * Tag: String
 * Time Comlexity: When the case that only the last string is different from the other strings, your code will take a long time, with worst case complexity being O(nk^2) where n is the number of strings and k is the average size of string. Note that indexOf() is O(n).
 * Space Comlexity: O(1)
**/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0,pre.length()-1);
            }              
        return pre;
    }
}