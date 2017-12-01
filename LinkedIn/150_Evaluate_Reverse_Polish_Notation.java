/**
 * Main Points: 
   using a stack to record previous tokens
   if meet an integer, push into stack
   if meet an operation, pop two token from stack and operate them to one number and them push into stack
 * Time Complexity: O(n) n = tockens.length
 * Space Complexity: O(n)
**/
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> numsStack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                numsStack.push(numsStack.pop() + numsStack.pop());
            } else if (token.equals("-")) {
                int substractor = numsStack.pop();
                int minuend = numsStack.pop();
                numsStack.push(minuend - substractor);
            } else if (token.equals("*")) {
                numsStack.push(numsStack.pop() * numsStack.pop());
            } else if (token.equals("/")) {
                int divisor = numsStack.pop();
                int dividend = numsStack.pop();
                numsStack.push(dividend / divisor);
            } else {
                numsStack.push(Integer.valueOf(token));
            }
        }
        return numsStack.pop();
    }
}