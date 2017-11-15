/**
 * Name: H-Index II
 * Number: 275
 * Tag: Binary Search
 * Main Points:
   to find the last position that make citations >= num of papers
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int start = 0, end = citations.length - 1;
        while (start + 1< end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] <= citations.length - mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (citations[start] >= citations.length - start) {
            return citations.length - start;
        } else if (citations[end] >= citations.length - end) {
            return citations.length - end;
        } else {
            return 0;
        }

    }
}