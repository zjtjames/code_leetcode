/**
 * created by Zheng Jiateng on 2019/7/21.
 */

import java.util.ArrayList;

/**
 * 43. Multiply Strings 大数相乘（字符串相乘）
 *
 * 思路：先不算任何的进位，也就是说，将每一位相乘，相加的结果保存到同一个位置，到最后才计算进位。
 例如：计算98×21,步骤如下
          9  8
 ×       2  1
 -------------
         (9)(8)  <---- 第1趟: 98×1的每一位结果
    (18)(16)     <---- 第2趟: 98×2的每一位结果
 -------------
   (18)(25)(8)  <---- 这里就是相对位的和，还没有累加进位
 */
public class MultiplyStrings__ {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()]; // a长的数 * b长的数，结果不会超过a+b长
        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // 因为进位的问题，整体右移1位，放置到第i+j+1位，把第0位空出来
            }
        }
        // 单独处理进位 高位结果被放在了前面 所以要从后往前进位
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

