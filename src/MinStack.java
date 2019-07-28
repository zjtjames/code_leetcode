/**
 * created by Zheng Jiateng on 2019/5/13.
 */

import java.util.Stack;

/**
 * 155. Min Stack
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty()) stackMin.push(x); // 注意如果stackMin为空 则无条件push
        else if(x <= stackMin.peek()) stackMin.push(x);
    }

    public void pop() {
        if(stack.peek() == stackMin.peek()) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

