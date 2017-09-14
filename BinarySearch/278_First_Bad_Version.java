/**
 * Name: First Bad Version
 * Number: 278
 * Tag: Binary Search
 * Main Point: using binary search to observe whether the mid version is bad, if mid version is bad, then the first bad version must be in the left range, move end to mid.if mid version is good, then the FBV must be in the right range, move start to mid.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
**/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) return 0;
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        if (isBadVersion(end)) {
            return end;
        }
        return -1;
    }
}