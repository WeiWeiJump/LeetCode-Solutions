package Linkedin;
import java.util.*;
public class MaximumNumberOfOverlappingIntervals {
    /*Maximum number of overlapping intervals
    For example – { (0,2), (3, 7), (4,6), (7,8), (1,5) }. The maximum number of intervals overlapped is 3 during (4,5).*/
    public static class Interval {
        int start;
        int end;
        Interval(int from, int to) {
            start = from;
            end = to;
        }
    }
    // first sort intervals by start  time
    // 2pointer start end to record the overlapping part's start and end
    // cur overplap = end - start + 1
    // max overlap keep updating
    public int maxNumOverlap(Interval[] intervals) {
        if (intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        int maxNumOverlap = 0;
        int idx = 0;
        while (idx < intervals.length) {
            if (heap.size() == 0 || isOverlap(heap.peek(), intervals[idx])) {
                heap.offer(intervals[idx]);
                idx++;
            } else {
                heap.poll();
            }
            maxNumOverlap = Math.max(maxNumOverlap, heap.size());
        }
        return maxNumOverlap;

    }
    private boolean isOverlap(Interval first, Interval second) {
        return second.start < first.end;
    }

    public static void main(String[] args) {
        MaximumNumberOfOverlappingIntervals test = new MaximumNumberOfOverlappingIntervals();
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(0,7);
        intervals[1] = new Interval(2,5);
        intervals[2] = new Interval(4,8);
        intervals[3] = new Interval(7,10);

        System.out.println(test.maxNumOverlap(intervals));
    }
}

          