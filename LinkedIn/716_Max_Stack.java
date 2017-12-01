/**
 * Main Points: keep a stack and a max stack
 stack stores all integers we push into it
 max stack sotres up to current stack, the max value 
 * Time Complexity: popMax O(n) n = all elements in stack 
 * Space Complexity: O(2n)
**/
class MaxStack {
    Stack<Integer> numStack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        numStack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        pushHelper(x);
    }
    
    private void pushHelper(int x) {
        int curMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > curMax) {
            curMax = x;
        }
        numStack.push(x);
        maxStack.push(curMax);
    }
    
    public int pop() {
        maxStack.pop();
        return numStack.pop();
    }
    
    public int top() {
        return numStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int target = maxStack.peek();
        Stack<Integer> tempStack = new Stack<>();
        while (numStack.peek() != target) {
            tempStack.push(numStack.pop());
            maxStack.pop();
        }
        numStack.pop();
        maxStack.pop();
        while (!tempStack.isEmpty()) {
            pushHelper(tempStack.pop());
        }
        return target;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */