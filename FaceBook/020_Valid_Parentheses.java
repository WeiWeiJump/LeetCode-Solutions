/**
 * Name: Valid Parentheses
 * Number: 20
 * Tag: Stack
 * Main Points: 
   if current char is left half of parenthesis, we should push it into the stack
   if current char is right half, we should check whether it's the same with stack.peek()
   if they are not same like [}, then return false
   if all right half finds it's left half, but final stack is not empty, like [[], then return false;
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}