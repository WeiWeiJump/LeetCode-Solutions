import java.util.*;
public class nearest_k_points {
    public static List<int[]> findNearestKPoints(int[][] points, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pointsHeap = new PriorityQueue<>(points.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return distance(b) - distance(a);
            }
        });
        for (int[] point : points) {
            pointsHeap.offer(point);
            if (pointsHeap.size() > k) {
                pointsHeap.poll();
            }
        }
        while(!pointsHeap.isEmpty()) {
            res.add(pointsHeap.poll());
        }
        return res;
    }
    private static int distance(int[] point) {
        //if (point.length < 2) return -1;
        return point[0] * point[0] + point[1] * point[1];
    }
    public static void main(String[] args) {
        int[][] points = {{0,3}, {2,4}, {-1,5}, {2,1}};
        List<int[]> res = findNearestKPoints(points, 3);
        for (int[] point : res) {
            System.out.println(point[0]);
            System.out.println(point[1]);
            System.out.println();
        }
    }
}
