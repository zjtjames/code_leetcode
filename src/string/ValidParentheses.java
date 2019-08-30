package string;

import java.util.Stack;

/**
 * Created by Zheng Jiateng on 2019/8/20.
 */

/**
 * 20. 有效的括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (!isEqual(c, stack.pop())) return false;
        }
        return stack.isEmpty();
    }

    private boolean isEqual(char a, char b) {
        return a == ')' && b == '(' || a == ']' && b == '[' || a == '}' && b == '{';
    }
}
