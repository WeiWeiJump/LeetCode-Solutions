/**
 * Name: Meeting Rooms
 * Number: 252
 * Tag: overide sort
 * Main Points: 
   sort meetings by start time
   record overall end time
   compare, if can attend, update end time
 * Time Complexity: O(nlogn)
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int endTime = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < endTime) {
                return false;
            }
            //update end
            endTime = intervals[i].end;
        }
        return true;
    }
}