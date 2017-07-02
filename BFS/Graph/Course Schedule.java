/**
 * Name: Course Schedule
 * Number: 207
 * Tag: Topological Sorting/BFS
 * Time Complexity: O(V + E) (using list to save neighbors of each node)
 * if we use matrix to save their relationship, TC will be O(V^2 + E) 
**/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        if (numCourses == 0) return true;
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegree = new int[numCourses]; // to save indegrees of all nodes
        List<Integer>[] preCanGo = new List[numCourses]; // tp save neighbors of each node for more easily scanning
        
        //initialize neighbors of each node 
        for (int i = 0; i < numCourses; i++) {
            preCanGo[i] = new LinkedList<Integer>();
        }
        //calculate indegrees of all nodes
        for (int[] pair: prerequisites) {
            int ready = pair[0];
            int pre = pair[1];
            indegree[ready]++;
            preCanGo[pre].add(ready);
        }
        //put all 0-indegree nodes into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //delete current node and its edge, loop
        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;
            for (int neighbor: preCanGo[curCourse]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}