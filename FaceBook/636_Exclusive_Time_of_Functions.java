/**
 * Name: Exclusive Time of Functions
 * Number: 636
 * Tag: Stack
 * Main Points:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null) return new int[0];
    
        int[] res = new int[n];
        Stack<Integer> idStack = new Stack<>();
        int pre = 0; // next inerval's start time
        for (String log : logs) {
            String[] parts = log.split(":");
            if (parts[1].equals("start")) {
                if (!idStack.isEmpty()) {
                    res[idStack.peek()] += Integer.valueOf(parts[2]) - pre;
                }
                idStack.push(Integer.valueOf(parts[0]));
                pre = Integer.valueOf(parts[2]);
            } else {
                res[idStack.pop()] += Integer.valueOf(parts[2]) - pre + 1;
                pre = Integer.valueOf(parts[2]) + 1;
            }
        }
        return res;
    }
}