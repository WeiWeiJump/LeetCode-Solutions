/**Name: Palindrome Partitioning
 * Number: 131
 * Tag: DFS/Backtracking
 * Root: Subsets
 * Time Complexity: O(2^n)
**/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        if (s.length() == 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        List<String> tempList = new ArrayList<>();
        DFSHelper(s, 0, res, tempList);
        return res;
    }
    private void DFSHelper(String s, int pos, List<List<String>> res, List<String> tempList) {
        if (pos == s.length()) { //means you have already deal with every char(whether cut a line before it or not)
            res.add(new ArrayList<String>(tempList));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            tempList.add(subString);
            DFSHelper(s, i + 1, res, tempList); 
            tempList.remove(tempList.size() - 1);
        }
    }
    private boolean isPalindrome(String subString) {
        for (int i = 0, j = subString.length() - 1; i < j; i++, j--) {
            if (subString.charAt(i) != subString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}