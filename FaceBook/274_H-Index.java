/**
 * Name: H-Index
 * Number: 274
 * Tag: bucket sort
 * Main Points:
   assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, then for any paper with reference    
   corresponding to the index of the bucket, we increment the count for that bucket. 
   The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
   Then we iterate from the back to the front of the buckets, 
   whenever the total count exceeds the index of the bucket, 
   meaning that we have the index number of papers that have reference greater than or equal to the index. 
   Which will be our h-index result. 
   The reason to scan from the end of the array is that we are looking for the greatest h-index. 
   For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++; 
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}