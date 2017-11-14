/**
 * Name: Simplify Path
 * Number: 71
 * Tag: Stack
 * Main Points:
   path -> split by "/" -> string[] parts
   for each p in parts
   if p != . && p!= .., push p into stack
   if p == . continue
   if p == .. stack.pop()
 * Time Complexity: O(path.length)
 * Space Complexity: O(path.length)
**/
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        
        Deque<String> stack = new LinkedList<>();
        String[] parts = path.split("/");
        for (String p : parts) {
            if (p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.equals("")) {
                stack.push(p);
            }
        }
        
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}