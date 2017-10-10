/**
 * Name: Decode String
 * Number: 394
 * Tag: Stack
 * Main Points: 
   for example, 3[ab2[cd]]
   to record "ab" before entering the second "[", we need to put it in the stack
   when meet first "]", pop "ab" out, appending "cd" for twice
   there should be a lvalue recording what to append on the res pop from stack
 * Time Complexity: O(?)
 * Space Complexity: O(n)
**/
class Solution {
    public String decodeString(String s) {
        if (s == null) return "";
        StringBuilder res = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = new StringBuilder();
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = resStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp;
                idx++;
            } else {
                res.append(s.charAt(idx++));
            }
        }
        return res.toString();
    }
}