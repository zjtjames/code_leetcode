/**
 * created by Zheng Jiateng on 2019/6/30.
 */

/**
 * 371. Sum of Two Integers 不用加减乘除实现二进制加法
 *
 * 思路：不用加减乘除做加法: 101 + 111 作为例子  二进制数不进位相加 等价于逐位异或
 * step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
 * step2:按位异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果
 * step3:n1&n2是查看有没有进位位了，如果有，需要重复step1、step2；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
 */
public class Add__ {
    public int getSum(int a, int b) {
        if ((a&b) == 0) return a ^ b;
        int num1 = (a & b) << 1;
        int num2 = a ^ b;
        return getSum(num1, num2);
    }
}
