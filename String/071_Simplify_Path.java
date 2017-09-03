/**
 * Name: Simplify Path
 * Number: 71
 * Tag: String/Deque
 * Main Point: Split all "/", if encountered with "." just skip it; 
   if encountered with "..", remove the file name that has just saved into the stringbuilder.
 * Missing Point: difference between "equals" and "=="  
 * Time Comlexity: O(path.length())
 * Space Complexity: O(path.length())
**/
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;
        Deque<String> deque = new LinkedList<>();        
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) { //corner case: /../
                    deque.pollLast();
                } 
            } else if (str.equals(".") || str.isEmpty()) {  //corner case: "/home//foo/".
                continue;
            } else {
                deque.offerLast(str);
            }
        }       
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
        return sb.length() == 0? "/" : sb.toString();  //corner case: "/"
    }
}