/**
 * Name: Course Schedule II
 * Number: 210
 * Tag: topological sorting
 * Main Points: 
   List[] to represent adj list
   indegree[] to represent each node's indegree
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int[] prerequisite : prerequisites) {
            int toStudy = prerequisite[0], pre = prerequisite[1];   
            adjList[pre].add(toStudy);
            indegree[toStudy]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            res.add(curCourse);
            for (int toStudy : adjList[curCourse]) {
                if (--indegree[toStudy] == 0) {
                    queue.offer(toStudy);
                }
            }
        }
        if (res.size() != numCourses) return new int[0];
        int[] ret = new int[numCourses];
        int j = 0;
        for (int i : res) {
            ret[j++] = i;
        }
        return ret;
    }
}