/**
 * created by Zheng Jiateng on 2019/7/12.
 */

/**
 * 190. Reverse Bits
 * 颠倒给定的 32 位无符号整数的二进制位
 *
 * 思路：位运算 用n&1每次取最低位 然后将n左移一位
 * 注意：1后面31个0 再左移1位 就变成了全0
 */
public class ReverseBits__ {
     // you need treat n as an unsigned value
     public int reverseBits(int n) {
         int result = 0;
         for(int i = 0; i < 32; i++){
             result += n & 1;
             if(i < 31){
                 n >>= 1;
                 result <<= 1;
             }
         }
         return result;
     }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1073741824));
//        10000000000000000000000000000000
//        10000000000000000000000000000001
        int i = 1073741824;
        i = i << 2;
        System.out.println(Integer.toBinaryString(i << 2));
    }
}
