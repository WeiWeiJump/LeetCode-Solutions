/**
 * Name: Course Schedule II
 * Number: 210
 * Tag: topological sorting
 * Main Points: 
   List[] to represent adj list
   indegree[] to represent each node's indegree
 * Time Complexity: O(V+E+V+V*E+V) E = V - 1(no circle) E = V(circle) -> O(V*V)
 * Space Complexity: O(n)
**/
//0:{1,2} 0
//1:{3}   1
//2:{3}   1
//3:{}    2
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] nextCourse = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nextCourse[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            nextCourse[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        } 
        List<Integer> courseList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            courseList.add(curCourse);
            for (int next : nextCourse[curCourse]) {
                if(--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (courseList.size() != numCourses) return new int[0];
        int[] res = new int[courseList.size()];
        int i = 0;
        for (int course : courseList) {
            res[i++] = course;
        }
        return res;
    }
}