/**
 * created by Zheng Jiateng on 2019/7/1.
 */

/**
 * 14. Longest Common Prefix
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * 思路：LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3​),…Sn​)
 * str1.indexOf(String str2) 返回str1中子串str2第一次出现的索引，若没出现返回-1
 */
public class LongestCommonPrefix__ {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String s1 = "abcbc";
        String s2 = "bc";
        System.out.println(s1.indexOf(s2, 1));
    }
}
