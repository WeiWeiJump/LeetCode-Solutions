/**
 * Name: Remove Invalid Parentheses
 * Number: 301 
**/
/************************  BFS Version  ***********************/
/* Tag: BFS
 * Main Points: 
 * Time Complexity: 
 In BFS we handle the states level by level, in the worst case, we need to handle all the levels, we can analyze the time complexity level by level and add them up to get the final complexity.

 On the first level, there's only one string which is the input string s, let's say the length of it is n, to check whether it's valid, we need O(n) time. On the second level, we remove one ( or ) from the first level, so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string, we need to check whether it's valid or not, thus the total time complexity on this level is (n-1) x C(n, n-1). Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...
 
 Finally we have this formula:
 T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1)
 * Space Complexity: O(n)
 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                found = true;
            }
            if (found) continue;
            
            //generate all states
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String next = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}


/**************************  DFS Version  *************************/
/* Tag: DFS(really tricky)
 * Main Points: 
   eg. ())(()
       (()(()
       (()())()) 
   first we want to remove extra right parenthesis, we keep iterating the string, checking 
   whether it's valid(right <= left), once it's invalid, we need to find a correct place to 
   remove a ')', 
 * Time Complexity:
 * Space Complexity:
 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
    private void remove(String s, List<String> res, int Last_i, int Last_j, char[] par) {
        for (int count = 0, i = Last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1]) count--;
            if (count >= 0) continue;
            //once count < 0, it means ')''s num start to be larger than '(''s num up to now during iteration
            //find a correct place(we always want to remove first ')') from last removal time to i, to remove extra ')'
            for (int j = Last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == Last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), res, i, j, par);
                }
            }
            return;
        }
        //finish removing all extra right parenthesis, then we reverse s
        String reversed = new StringBuilder(s).reverse().toString();
            
        if (par[1] == ')') { //finished left to right
            remove(reversed, res, 0, 0, new char[]{')', '('});
        } else { //finished right to left
            res.add(reversed);
        }        
    }
}