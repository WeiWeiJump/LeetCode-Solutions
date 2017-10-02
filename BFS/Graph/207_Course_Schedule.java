/**
 * Name: Course Schedule
 * Number: 207
 * Tag: Topological Sorting + BFS/DFS
 * Main Points:
   first we build the index map, key is the current course, value is its prerequisite.
   Then use topological sorting to decide whether it's valid.
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
**/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] nextOfCourse = new List[numCourses];
        int[] indegree = new int[numCourses];
        //initialize
        //O(V)
        for (int i = 0; i < numCourses; i++) {
            nextOfCourse[i] = new ArrayList<Integer>();
        }
        //construct the map of prerequisite and course, record every node's indegree
        //O(E)
        for (int[] prerequisite : prerequisites) {
            nextOfCourse[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        //BFS curLevel we should visit nodes whose indegree = 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //O(V)
        int visitedCourse = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            for (int nextCourse : nextOfCourse[curCourse]) {
                if(--indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
            visitedCourse++;
        }
        return visitedCourse == numCourses;
    }
}