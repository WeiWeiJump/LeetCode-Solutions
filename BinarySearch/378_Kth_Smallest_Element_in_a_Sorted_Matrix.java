/**
 * Name: Kth Smallest Element in a Sorted Matrix
 * Number: 378
 * Tag: binary search/heap
 * Main Points:
 (1)Binary Search: in range
   The key point for any binary search is to figure out the "Search Space". For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".
   in this case, we should find the first number in the range that makes (count <= mid) >= k
   initial range 1 ~ 15, mid = 8, k = 8
   count <= mid -> 2个, < k, then update range to be 8 ~ 15, mid = 11
   count <= mid -> 5个, < k, then update range to be 11 ~ 15, mid = 13
   count <= mid -> 8个, == k, then update range to be 11 ~ 13, mid = 12
   count <= mid -> 6个, < k, then update range to be 12 ~ 13
 * Time Complexity: O(n^2*log(range))
 * Space Complexity: O(1)
**/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(matrix, mid) == k) {
                end = mid; // to find the first number, if to find last, just change end to start
            } else if (count(matrix, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(matrix, start) >= k) {
            return start;
        }
        if (count(matrix, end) >= k) {
            return end;
        }
        return -1;
    }
    //count the numbers in matrix which <= mid
    private int count(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {     
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            count += (j + 1);
        }
        return count;
    }
}

/*****************************************Heap*******************************************/
/**
 * (2) Heap: 
   1.Build a minHeap of elements from the first row.
   2.Do the following operations k-1 times: Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element(so we can create a tuple class here), replace that root with the next element from the same column. Therefore, we keep adding current min value from those points not in the heap, and we poll out the points in an increasing order of their value.
   Time Complexity: O(matrix.length + klog(matrix.length))
   Space Complexity: O(matrix.length)
**/ 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix[0].length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 1; i < k; i++) {
            Tuple t = pq.poll();
            if(t.r == matrix.length - 1) continue;
            pq.offer(new Tuple(t.r + 1, t.c, matrix[t.r + 1][t.c]));
        }
        return pq.poll().val;
    }
}
class Tuple implements Comparable<Tuple>{
    int r, c, val;
    public Tuple (int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}