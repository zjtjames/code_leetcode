/**
 * created by Zheng Jiateng on 2019/7/28.
 */
package string;

/**
 * 151.翻转字符串里的单词
 *
 * 思路：从后往前遍历 用s.substring截取
 * 最后用sb.deleteCharAt(0)删除第一个空格
 */
public class ReverseWords {
    public String reverseWords(String s) {
        int n = s.length();
        if(n < 1) return "";
        int i = n - 1;
        StringBuffer sb = new StringBuffer();
        while(i >= 0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
            int j = i;
            while(j >= 0 && s.charAt(j) != ' ') j--;
            sb.append(" ").append(s.substring(j + 1, i + 1));
            i = j;
        }
        if(sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }
}
