/**
 * Name: Task Scheduler
 * Number: 257
 * Tag: sort
 * Main Points: set a frame
   append the less frequent characters to the end of each chunk of the first k-1 chunks sequentially and round and round, then join the chunks and keep their heads' relative distance from each other to be at least n.
   final result is always either tasks' length or the initial frame length, we choose the larger one.
 * Time Complexity: O(n)
 * Space Complexity: O(26)
**/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n <= 0) return tasks.length;
        
        int[] list = new int[26];
        for (char task : tasks) {
            list[task - 'A']++;
        }
        Arrays.sort(list);
        if (list[25] != 0) {
            int i = 24;
            while (i >= 0 && list[i] == list[25]) {
                i--;
            }
            return Math.max(tasks.length, (list[25] - 1) * (n + 1) + 25 - i);
        }
        return 0;
    }
}

//follow up: what is we cannot change the order of tasks
//use a map to store the least position that key should appear next time
//Time Complexity: O(n)
//Space Complexity: O(n)
public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i]) || map.get(tasks[i]) <= ret) {
                ret++;
            } else {
                ret = map.get(tasks[i]) + 1;
            }
            map.put(tasks[i], ret + n);
        }
        return ret;
}
 