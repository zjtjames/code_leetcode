/**
 * created by Zheng Jiateng on 2019/7/28.
 */
package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 71.简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 思路：用一个stack存有效信息(字母) 遇到..就pop 最后按规范拼出路径
 * s.split("/") 注意split会分出空字符串
 */
public class SimplifyPath__ {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        HashSet<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        String[] strs = path.split("/");
        for(String str : strs){
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!skip.contains(str)) stack.push(str); // 遇到空字符串 . .. 直接跳过
        }
        String result = "";
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        return result.equals("") ? "/" : result; // 注意根目录要用/表示
    }
}
