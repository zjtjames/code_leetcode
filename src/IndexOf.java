/**
 * created by Zheng Jiateng on 2019/7/3.
 */

/**
 * 28. Implement strStr()
 * java的str.indexOf(String s)方法
 */
public class IndexOf {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len == 0) return 0;
        for(int i = 0; i <= haystack.length() - len; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 1;
                for(; j < len; j++){
                    if(haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if(j == len) return i;
            }
        }
        return -1;
    }
}
