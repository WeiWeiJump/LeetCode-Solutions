/**
 * Name: Is Subsequence
 * Number: 392
 * Tag: binary search / 2 pointers
 * Main Points: 
   (1)Method1: 2 pointes
   Time Complexity: O(s.length + t.length);
   Space Complexity: O(1)
   (2)Method2: binary search
   first we constuct a map for t, the key of the map is the elements in t, the value is the a list including all the pos it appears. Then in s, traverse all elements in s, binary search the available insert position.(Available position means the pos nearest to the previous element).
   Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
   Eg-1. s="abc", t="bahbgdca"
   idx=[a={1,7}, b={0,3}, c={6}]
   i=0 ('a'): prev=1
   i=1 ('b'): prev=3
   i=2 ('c'): prev=6 (return true)
   Eg-2. s="abc", t="bahgdcb"
   idx=[a={1}, b={0,6}, c={5}]
   i=0 ('a'): prev=1
   i=1 ('b'): prev=6
   i=2 ('c'): prev=? (return false)
**/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        } 
        int posS = 0, posT = 0;
        while(posS < s.length() && posT < t.length()) {
            if (s.charAt(posS) == t.charAt(posT)) {
                if (posS == s.length() - 1) {
                    return true;
                }
                posS++;
            }
            posT++;
        }
        return false;
    }
}

/*************************follow up*************************/

class Solution {
    public boolean isSubsequence(String s, String t) {
        //construct the map storing (char, all its pos)
        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null) {
                idx[t.charAt(i)] = new ArrayList<>();
            }
            idx[t.charAt(i)].add(i);
         }   
        //prev means 当前char在idx数组中最小的有效位置
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            //xab aabb, idx[x]没被建立过，直接返回
            if (idx[s.charAt(i)] == null) return false;
            //search available position in idx[]
            int pos = Collections.binarySearch(idx[s.charAt(i)], prev);
            //transfer to insert position if not found
            if (pos < 0){
                pos = -(pos + 1);
            }
            //if like eg2, available position is in the end of the array
            //it means all the posions in idx[s.charAt(i)] are not valid
            if (pos == idx[s.charAt(i)].size()) return false;
            //update next char's available position
            prev = idx[s.charAt(i)].get(pos) + 1;
        }
        return true;
    }
}
