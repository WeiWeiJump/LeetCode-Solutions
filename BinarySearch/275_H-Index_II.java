/**
 * Name: H-Index II
 * Number: 275
 * Tag: Binary Search
 * Main Point: use binary search to divide the papers into to group
   decide: if citations[mid] == citations.length - mid, return citations[mid];
   if citations[mid] < citations.length - mid, start = mid;
   if citations[mid] > citations.length - mid, end = mid;
 * Time Comlexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int start = 0, end = citations.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] < citations.length - mid) {
                start = mid;
            } else {
                end = mid;
            }
        }  
        if (citations[end] <= citations.length - end) {
            return citations[end];
        }
        if (citations[start] <= citations.length - start) {
            return Math.max(citations[start], citations.length - end);
        }
        return citations.length - start;
    }
}