/**
 * created by Zheng Jiateng on 2019/6/13.
 */

import java.util.Stack;

/**
 * 227. Basic Calculator II 中序表达式四则运算
 * 表达式中有加减乘除，空格，和数字
 *
 * 思路： +13 -4/2*5 + 1 精髓是最开始加一个+
 */
public class BasicCalculatorII__ {
    public int calculate(String s) {
        int result = 0;
        int len = s.length();
        if (len < 1) return result;
        char operator = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + s.charAt(i) - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == len -1) {
                if (operator == '+') {
                    stack.push(num);
                }
                if (operator == '-') {
                    stack.push(0 - num);
                }
                if (operator == '*') {
                    stack.push(stack.pop() * num);
                }
                if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                operator = c;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
