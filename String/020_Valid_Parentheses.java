/** 
 * Name: Valid Parentheses
 * Number: 20
 * Tag: Stack
 * Time Comlexity: O(n)
 * Space Complexity: O(n)
**/
public class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (isPair(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }   
        return stack.isEmpty();
    }
    
    public boolean isPair(char i, char j) {
        if (i == '(' && j == ')') return true;
        if (i == '{' && j == '}') return true;
        if (i == '[' && j == ']') return true;
        return false;
    }
}