/**
 * created by Zheng Jiateng on 2019/7/6.
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 生成有效的小括号序列
 * 例如n=3时，结果为
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * 总结：回溯法的backtrack递归函数的参数，要根据问题的限制条件来自定义，参数体现问题的限制条件
 * generate类的题（即生成某东西），都是回溯法
 */
public class GenerateParenthesis__ {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return result;
    }

    private void backtrack(String cur, int open, int close, int n){
        if(cur.length() == 2 * n){
            result.add(cur);
            return;
        }
        if(open < n){
            backtrack(cur + "(", open + 1, close, n);
        }
        if(close < open){
            backtrack(cur + ")", open, close + 1, n);
        }
    }
}
