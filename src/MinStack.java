/**
 * created by Zheng Jiateng on 2019/5/13.
 */

import java.util.Stack;

/**
 * 155. Min Stack
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 思路：增加一个栈存储最小元素
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

