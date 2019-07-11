/**
 * created by Zheng Jiateng on 2019/7/11.
 */

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation 后缀表达式求值
 *
 * 思路：用栈 遇到数字push 遇到运算符pop
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int op2 = nums.pop();
                int op1 = nums.pop();
                nums.push(op1 + op2);
            } else if (str.equals("-")) {
                int op2 = nums.pop();
                int op1 = nums.pop();
                nums.push(op1 - op2);
            } else if (str.equals("*")) {
                int op2 = nums.pop();
                int op1 = nums.pop();
                nums.push(op1 * op2);
            } else if (str.equals("/")) {
                int op2 = nums.pop();
                int op1 = nums.pop();
                nums.push(op1 / op2);
            } else {
                nums.push(Integer.valueOf(str));
            }
        }
        return nums.pop();
    }
}
