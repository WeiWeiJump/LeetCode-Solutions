/**
 * Main Points:
   The main idea is to store the last seen positions of current (i-th) characters in both strings. 
   If previously stored positions are different then we know that they're not occuring in the current i-th position simultaneously
 * Time Complexity: O(n) n = length of the string
 * Space Complexity: O(512)
**/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() != t.length()) return false;
        
        int[] posOfS = new int[256], posOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (posOfS[s.charAt(i)] != posOfT[t.charAt(i)]) return false;
            posOfS[s.charAt(i)] = posOfT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

//follow up
/*Given 3 strings s and t and e, determine if they are isomorphic.

  For example,
  Given "egg", "add", "foo", "paper", "title"，return {{"egg", "add", "foo"}，{"paper", "title"}}.

*/
public class isomorphicString {
    public List<List<String>> isIsomorphic(String[] inputs) {
        if (inputs == null || inputs.length == 0) return null;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : inputs) {
            Map<Character, Integer> indexMap = new HashMap<>();
            int idx = 0;
            StringBuilder tmp = new StringBuilder();
            for (char c : str.toCharArray()) {
                char decode;
                if (!indexMap.containsKey(c)) {
                    indexMap.put(c, idx);
                    decode = (char)('a' + idx++);
                } else {
                    decode = (char)('a' + indexMap.get(c));
                }
                tmp.append(decode);
            }
            String newStr = tmp.toString();
            if (!map.containsKey(newStr)) {
                map.put(newStr, new LinkedList<>());
            }
            map.get(newStr).add(str);
        } // for str

        List<List<String>> res = new ArrayList<List<String>>(map.values());
        return res;
    }
}
