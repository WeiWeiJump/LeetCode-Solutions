/**
 * Name: Group Anagrams
 * Number: 49
 * Tag: 
 * Main Points: anagrams are the same after sorted in lexicographical order.
   So we can use a map, key is the sorted string, 
   value is the corresponding strings that be can transformed to key after sorted.
 * Time Complexity: mnlogn
   n-length of a single string
   m-number of Strings
 * Space Complexity: O(n)
**/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //turn String to char Array
            char[] sToCharArray = s.toCharArray();
            //sort char Array
            Arrays.sort(sToCharArray);
            //turn char Array back to String
            String sorted = String.valueOf(sToCharArray);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            } 
            map.get(sorted).add(s);             
        }
        //output map
        return new ArrayList<List<String>>(map.values());
    }
}