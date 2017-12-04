package Linkedin;
import java.util.*;
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
