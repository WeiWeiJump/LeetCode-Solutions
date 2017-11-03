/**
 * Name: Merge Intervals
 * Number: 56
 * Tag: tricky
 * Main Points: first we sort the intervals by start time,
   we keep a start and a end to record up to now, the intersected interval's start and end
   we iterate the sorted interval list,
   when we meet a new interval, we compare its start to current end,
   if the former > latter, then they have no intersection, change the start and end to current interval
   if the former < latter, then they have inersection, update end to current interval's end
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        
        //sort intervals list, overwrite comparator
        //java-7 method:
        /*Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }  
        });*/
        //java-8 method:
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        //inialize start and end
        int startTime = intervals.get(0).start;
        int endTime = intervals.get(0).end;
        //iterate the sorted list
        for (Interval interval : intervals) {
            if (interval.start <= endTime) { 
                //overlap, update end
                endTime = Math.max(interval.end, endTime);
            } else { 
                //disjoint intervals, add previous one and reset bound
                res.add(new Interval(startTime, endTime));
                startTime = interval.start;
                endTime = interval.end;
            }
        }
        //add last interval
        res.add(new Interval(startTime, endTime));
        return res;
    }
}