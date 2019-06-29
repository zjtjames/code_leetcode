/**
 * created by Zheng Jiateng on 2019/6/29.
 */

/**
 * 191. Number of 1 Bits
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
