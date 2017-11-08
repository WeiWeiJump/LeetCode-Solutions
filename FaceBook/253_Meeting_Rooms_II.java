/**
 * Name: Meeting Rooms II
 * Number: 253
 * Tag: heap
 * Main Points: 
   first we need to sort all the meetings by start time 
   then we use heap to store all meeting rooms, 
   and min heap(compare by end time) to always make the room that ends meeting first at the top
   when meet with a new meeting, compare its start time with top room's end time, 
   if the former < latter, they cannot be in same room, so arrange a new room for this meeting
   if            >       , they can be in same room, update this room's time schedule
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;    
            } 
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //most possibly room
            Interval mpRoom = heap.poll();
            //could be arranged in same room, merge the interval
            if (intervals[i].start >= mpRoom.end) {
                mpRoom.end = intervals[i].end;
            } else {
                //otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }
            //don't forget to put the meeting room back
            heap.offer(mpRoom);       
        }
        return heap.size();
    }
}