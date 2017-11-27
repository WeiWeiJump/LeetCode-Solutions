import java.util.*;
public class _621_Task_scheduler_follow_up {
    //eg. tasks = {A,A,B,B,C,A}, can change order
    /*public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] times = new int[26];
        for (char c : tasks) {
            times[c - 'A']++;
        }
        Arrays.sort(times);
        int res = 0;
        if (times[25] != 0) {
            int i = 24;
            while (times[i] == times[25]) i--;
            return Math.max(tasks.length, (times[25] - 1) * (n + 1)) + 25 - i;
        }
        return 0;
    }*/
    //follow up: order cannot change
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        //use a map to store the least position that key should appear next time
        Map<Character, Integer> map = new HashMap<>();
        int interval = 0;
        for (char task : tasks) {
            if (!map.containsKey(task) || map.get(task) < interval) {
                interval++;
                map.put(task, interval + n);
            } else {
                interval = map.get(task) + 1;
            }
        }
        return interval;
    }
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'B', 'B', 'C', 'A'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
