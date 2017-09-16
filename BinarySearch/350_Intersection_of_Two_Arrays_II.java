/**
 * Name: Intersection of Two Arrays II
 * Number: 350
 * Tag: HashMap/2pointers
 * Main Points: using HashMap to keep records of each elements' value and the times it appears in nums1. Then search the map for each elements in nums2, if we find one, then decrease the times it appears.use linkedlist to save the result(fast add).
 * Time Complexity: O(nums1.length + nums2.length)
 * Space Complexity: O()
**/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> intersection = new LinkedList<>();
        for (int num1 : nums1) {
            if (map.containsKey(num1)) {
                map.put(num1, map.get(num1) + 1);
            } else {
                map.put(num1, 1);
            }
        }
        for (int num2 : nums2) {
            if (map.containsKey(num2) && map.get(num2) > 0) {
                intersection.add(num2);
                map.put(num2, map.get(num2) - 1);
            } 
        }
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int n : intersection) {
            res[i] = n;
            i++;
        }
        return res;
    }
}