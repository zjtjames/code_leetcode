/**
 * Created by Zheng Jiateng on 2019/5/17.
 */

/**
 * 171. Excel Sheet Column Number
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 *  AA -> 27
 * AB -> 28
 * ...
 *
 * 相当于二十六进制
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();// 一定要注意 字符串的length方法加括号
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = 26 * result + numberOfChar(s.charAt(i));
        }
        return result;
    }

    private int numberOfChar(char c) {
        return c - 'A' + 1;
    }
}
