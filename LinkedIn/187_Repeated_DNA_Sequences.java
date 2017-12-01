/**
 * Main Points:
   1. decode a target string to be a int (A-00, C-01, G-10, T-11)
   2. search in whole string 10 chars after 10 chars, calculate decoded integer
   3. put the integer and its frequency to a map, when frequency reaches 2, add it into final result
 * Time Complexity: O(n-10)*10) n = s.length()
 * Space Complexity: O(n-10) n = s.length()
**/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedDNA = new ArrayList<>();
        if (s == null || s.length() == 0) return repeatedDNA;
        int[] decodeWay = new int[26];
        decodeWay['C' - 'A'] = 1;
        decodeWay['G' - 'A'] = 2;
        decodeWay['T' - 'A'] = 3;
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < s.length() - 9; i++) {
            int decode = 0;
            for (int j = i; j < i + 10; j++) {
                decode <<= 2;
                decode |= decodeWay[s.charAt(j) - 'A'];
            }
            freqMap.put(decode, freqMap.getOrDefault(decode, 0) + 1);
            if (freqMap.get(decode) == 2) {
                repeatedDNA.add(s.substring(i, i + 10));
            }
        }
        return repeatedDNA;
    }
}