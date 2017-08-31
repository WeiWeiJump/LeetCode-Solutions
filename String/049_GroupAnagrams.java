me: Group Anagrams
 * Number: 49
 * Tag: HashMap
 * Main Point: Anagrams will be the same if sorted in alphabetical order.
   Take the sorted result as the key, and map the strings of the same key into a group.
 * Time Complexity: O(n * slogs) n: the number of strs, s: the max length of str
 * Space Complexity: O(n * s)
**/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

