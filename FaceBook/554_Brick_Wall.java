/**
 * Name: Brick Wall
 * Number: 554
 * Tag: HashMap
 * Main Points:
   (length, frequency) -> map
   We want to cut from the edge of the most common location among all the levels, 
   hence using a map to record the locations and their corresponding occurrence
 * Time Complexity: O(num of bricks)
 * Space Complexity: O(num of bricks)
**/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
        }
        
        //iterate map, to find max frequency
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            max = Math.max(max, val);
        }
        return wall.size() - max;
    }
}