/**
 * created by Zheng Jiateng on 2019/6/29.
 */

/**
 * 191. Number of 1 Bits
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数
 *
 * 思路：n&(n-1)可以把二进制数字最低位的1变成0
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
