/**
 * Name: Basic Calculator II
 * Number: 227
 * Tag: Stack
 * Main Point: "37+2*2" = 7, put +37 into stack, then +2 into stack, when encountered *, pop +2 out to do *2
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;         
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (operation == '+') stack.push(+num);
                if (operation == '-') stack.push(-num);
                if (operation == '*') stack.push(stack.pop() * num);
                if (operation == '/') stack.push(stack.pop() / num);
                operation = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        for (int part : stack) {
            sum += part;
        }
        return sum;
    }
}