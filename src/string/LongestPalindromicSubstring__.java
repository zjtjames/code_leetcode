package string; /**
 * created by Zheng Jiateng on 2019/7/16.
 */

/**
 * 5. Longest Palindromic Substring
 * 最长回文子串
 *
 * 思路：若s1为回文 则s1左右加相同字母为更长的回文  如aba 左右加c cabac仍为回文
 * 所以思路为从中心向两边扩展
 * 一个长n的字符串 共有2n-1个中心可以扩展 如 aba中心为b  abba 中心为两个b之间
 */
public class LongestPalindromicSubstring__ {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        // 记录最长回文的头尾索引
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start + 1){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
