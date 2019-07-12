/**
 * created by Zheng Jiateng on 2019/7/12.
 */

/**
 * 190. Reverse Bits
 */
public class ReverseBits {
//     you need treat n as an unsigned value
//    public int reverseBits(int n) {
//        String.
//    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1073741824));
//        10000000000000000000000000000000
//        10000000000000000000000000000001
        int i = 1073741824;
        i = i << 2;
        System.out.println(Integer.toBinaryString(i << 2));
    }
}
