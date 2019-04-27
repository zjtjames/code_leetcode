/**
 * created by Zheng Jiateng on 2019/4/27.
 */

/**
 * 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i< len/2; i++){
            exchange(s, i, len - 1 -i);
        }
    }

    private void exchange(char[] s, int j, int k){
        char temp = s[j];
        s[j] = s[k];
        s[k] = temp;
    }
}
