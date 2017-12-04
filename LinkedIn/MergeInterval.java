package Linkedin;
import java.util.*;
//public interface Intervals {
    /**
     * Adds an interval [from, to] into internal structure.
     */
  //void addInterval(int from, int to);
  /**
 * Returns a total length covered by intervals.
 * If several intervals intersect, intersection should be counted only once.
 * Example:
 *
 * addInterval(3, 6)
 * addInterval(8, 9)
 * addInterval(1, 5)
 *
 * getTotalCoveredLength() -> 6
 * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
 * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
 *
 */
  //int getTotalCoveredLength();

//}

  /* Use a list to store the intervals.
     -- add(), add into the end of the list, so the complexity is O(1).
     -- getLength(), very similar to the merge interval. First sort the list of intervals,
     find the longest overlapped interval and calculate the length. The complexity is O(nlogn)*/

public class MergeInterval{
      public static class Interval {
          int start;
          int end;
          Interval(int from, int to) {
              start = from;
              end = to;
          }
      }
      List<Interval> intervals = new ArrayList<>();
      public void addInterval(int from, int to) {
          intervals.add(new Interval(from, to));
      }
      public int getTotalCoveredLength() {
          if (intervals.isEmpty()) return 0;
          Collections.sort(intervals, new Comparator<Interval>() {
              public int compare(Interval a, Interval b) {
                  return a.start - b.start;
              }
          });
          int totalLen = 0;
          Interval prev = intervals.get(0);
          for (int i = 1; i < intervals.size(); i++) {
              Interval cur = intervals.get(i);
              if (overlaps(prev, cur)) {
                  prev.end = Math.max(prev.end , cur.end);
              } else {
                  totalLen += prev.end - prev.start;
                  prev = cur;
              }

          }
          totalLen += prev.end - prev.start;
          return totalLen;
      }

      boolean overlaps(Interval prev, Interval cur) {
          return cur.start < prev.end;
      }
      public static void main (String[] args) {
          MergeInterval test = new MergeInterval();
          test.addInterval(1,5);
          test.addInterval(3,6);
          test.addInterval(8,9);
          System.out.println(test.getTotalCoveredLength());
      }
}
