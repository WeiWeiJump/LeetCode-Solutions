/**
 * Main Points: 
   in wordDistance, we use hashmap to store each word and its list of index
   in shortest, we use two pointers to perform comparison in O(n + m) time (list1 size n, list2 size m)
 * Time Complexity:
 * Space Complexity:
**/
class WordDistance {
    Map<String, List<Integer>> indexMap = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!indexMap.containsKey(word)) {
                List<Integer> indexList = new ArrayList<>();
                indexMap.put(word, indexList);
            }    
            indexMap.get(word).add(i);   
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indexList1 = indexMap.get(word1);
        List<Integer> indexList2 = indexMap.get(word2);
        int ptr1 = 0, ptr2 = 0, distance = Integer.MAX_VALUE;
        while (ptr1 < indexList1.size() && ptr2 < indexList2.size()) {
            int index1 = indexList1.get(ptr1);
            int index2 = indexList2.get(ptr2);
            if (index1 < index2) {
                distance = Math.min(distance, index2 - index1);
                ptr1++;
            } else {
                distance = Math.min(distance, index1 - index2);
                ptr2++;
            }
        }
        return distance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */