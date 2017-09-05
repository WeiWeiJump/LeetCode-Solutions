/**
 * Name: Ransom Note
 * Number: 383
 * Tag: String
 * Time Comlexity: O(magazine.lenth)
 * Space Complexity: O(1)
**/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (count[ransomNote.charAt(i) - 'a']-- < 1) {
                return false;
            }
        }
        return true;
    }
}