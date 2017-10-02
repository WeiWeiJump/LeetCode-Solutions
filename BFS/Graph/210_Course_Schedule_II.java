/**
 * Name: Course Schedule II
 * Number: 210
 * Tag: Topological Sorting/BFS
 * Main Points: same as 207
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
**/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] nextOfCourse = new List[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        //initialize
        for (int i = 0; i < numCourses; i++) {
            nextOfCourse[i] = new ArrayList<Integer>();
        }
        //construct the map from prerequisite to curCourse
        for (int[] prerequisite: prerequisites) {
            nextOfCourse[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            res.add(curCourse);
            List<Integer> nextCourses =  nextOfCourse[curCourse];
            for (int nextCourse : nextCourses) {
                if (--indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        //turn list to int[]
        int[] ret = new int[numCourses];
        if (res.size() == numCourses) {
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        }
        return new int[0];
    }
}