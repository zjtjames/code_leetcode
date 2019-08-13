/**
 * created by Zheng Jiateng on 2019/8/13.
 */
package string;

/**
 * 91. 解码方法
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 *
 * 思路：dp 当前数字只有两类解码方法：1.单独解码 2.与前一个数字一起解码
 */
public class NumDecodings__ {
    public int numDecodings(String s) {
        if(s.length() < 1) return 1;
        int[] dp = new int[s.length() + 1]; //dp[i]表示长度为i的字符串的解法数量
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= s.length(); i++){
            int one = Integer.valueOf(s.substring(i-1, i)); // 只包含当前数字
            int two = Integer.valueOf(s.substring(i-2, i)); // 当前数字和前一个数字
            if(one != 0){
                dp[i] += dp[i-1]; // 当前数字不为时可以单独解码
            }
            if(two >= 10 && two <= 26){
                dp[i] += dp[i-2]; // 当前数字和前一个数字一起大于等于10小于等于26时可以一起解码
            }
        }
        return dp[s.length()];
    }
}
