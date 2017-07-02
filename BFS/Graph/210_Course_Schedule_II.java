/**
 * Name: Course Schedule II 
 * Number: 210
 * Tag: Topological Sorting
 * Time Complexity: O(V + E)
**/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        
        List<Integer> order = new ArrayList<>();
        int[] indegree = new int[numCourses];
        List<Integer>[] preCanGo = new List[numCourses];
        
        //initialize the relationship list
        for (int i = 0; i < numCourses; i++) {
            preCanGo[i] = new LinkedList<Integer>();
        }
        //calculate indegrees of all nodes
        for (int[] preCourse: prerequisites) {
            indegree[preCourse[0]]++;
            preCanGo[preCourse[1]].add(preCourse[0]);
        }
        //put all 0-indegree nodes into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        //BFS all 0-indegree nodes
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            order.add(curCourse);
            for (int goCourse: preCanGo[curCourse]) {
                indegree[goCourse]--;
                if (indegree[goCourse] == 0) {
                    queue.add(goCourse);
                }
            }
        }
        //copy the list to array
        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }
        if (res.length != numCourses) return new int[]{};
        else return res;    
    }
}