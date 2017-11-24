/**
 * Name: Intersection of Two Arrays
 * Number: 349
 * Tag: HashSet
 * Main Points:
 * Time Complexity: O(n)
 * Space Complexity: O(2n)
**/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                intersect.add(num2);
            }
        }
        int[] res = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            res[i++] = num;
        }
        return res;
    }
}