/**
 * Name: Intersection of Two Arrays
 * Number: 349
 * Tag: HashSet/Binary Search/2 pointers
 * Main Points:
   (1)Hashset: using hashset to record all the numbers in nums1, then check if nums2 has those elements. 
   Time Complexity: O(nums1.length + nums2.length) 
   Space Complexity: O(nums1.length + intersection.length)
   (2)2pointers: sort two arrays, compare them in order. If nums[p1] == nums[p2], add this num to a set, p1 and p2 move forward. if nums1[p1] < nums2[p2], then p1 move forward, vise versa.
   Time Complexity: O(nums1.length*Log(nums1.length) + nums2.length*(nums2.length)) 
   Space Complexity: O(intersection.length)
   (3)binary search: sort nums1, binary search elements of nums2 in nums1
   Time Complexity: O((nums2+nums1).length*log(nums1.length))
   Space Complexity: O(intersection.length)
**/

/***********************************   HashSet   ***************************************/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();
        
        for (int num1 : nums1) {
            set.add(num1);
        }
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                intersectionSet.add(num2);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int i = 0;
        for (int num : intersectionSet) {
            intersection[i] = num;
            i++;
        }
        return intersection;
    }
}
/************************************   2Pointers   ************************************/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> intersection = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums2[p2] < nums1[p1]) {
                p2++;
            } else {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            res[i] = num;
            i++;
        }
        return res;     
    }
}
/*************************************  binary search   ******************************/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> intersection = new HashSet<>();
        Arrays.sort(nums1);
        for (int target : nums2) {
            //binary search n in nums1
            int start = 0, end = nums1.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums1[mid] == target) {
                    intersection.add(target);
                    break;
                } else if (nums1[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums1[start] == target || nums1[end] == target) {
                intersection.add(target);
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
