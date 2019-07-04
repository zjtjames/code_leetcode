/**
 * created by Zheng Jiateng on 2019/7/3.
 */

/**
 * 7. Reverse Integer
 *
 * 思路：先取绝对值 不管x的正负 用同一段代码进行翻转 最后return的时候再分正负数
 */
public class ReverseInteger {
    public static int reverse(int x) {
        String s = String.valueOf(Math.abs(x));
        int len = s.length();
        char[] chars = s.toCharArray();
        String s1, s2;
        if (x == 0) return x;
        else {
            int cur = 0;
            for (int i = 0; i < len / 2; i++) {
                char tmp = chars[i];
                chars[i] = chars[len - 1 - i];
                chars[len - 1 - i] = tmp;
            }
            while (chars[cur] == '0') cur++;
            s1 = String.valueOf(chars);
            s2 = s1.substring(cur, len);
        }
        try {
            return x > 0 ? Integer.valueOf(s2) : -1 * Integer.valueOf(s2);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1000));
    }
}
