package Linkedin;
import java.util.*;

//public interface PointsOnAPlane {
    /**
     * Stores a given point in an internal data structure.
     */
    //void addPoint(Point point);

    /**
     * For given 'center' point returns a subset of 'p' stored points
     * that are closer to the center than others.. visit 1point3acres.com for more.
     *
     * E.g.
     * Stored:
     * (1, 1)
     * (0, 3)
     * (0, 4)
     * (0, 5)
     * (0, 6)
     * (0, 7)
     *
     * findNearest(new Point(0, 0), 3) -> (1, 1), (0, 3), (0, 4).
     */


    /*Collection<Point> findNearest(Point center, int p);


}*/
public class nearestKPoints {
    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    List<Point> points = new ArrayList<>();
    public void addPoint(Point point) { //O(1)
        points.add(point);
    }
    public Collection<Point> findNearest(Point center, int p) { //O(nlogk) O(k)
        PriorityQueue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return distance(b, center) - distance(a, center);
            }
        });
        for (Point point : points) {
            heap.offer(point);
            if (heap.size() > p) {
                heap.poll();
            }
        }
        return new ArrayList<Point>(heap);
    }
    private int distance(Point a, Point center) {
        int xdiff = a.x - center.x;
        int ydiff = a.y - center.y;
        return Math.abs(xdiff * xdiff + ydiff * ydiff);
    }

    public static void main(String[] args) {
        nearestKPoints test = new nearestKPoints();
        test.addPoint(new Point(1,1));
        test.addPoint(new Point(0,3));
        test.addPoint(new Point(0,4));
        test.addPoint(new Point(0,5));
        test.addPoint(new Point(0,6));
        test.addPoint(new Point(0,7));

        for (Point p : test.findNearest(new Point(0, 0), 3)) {
            System.out.println(p.x + ", " + p.y);
        }
    }
}