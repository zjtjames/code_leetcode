package string; /**
 * created by Zheng Jiateng on 2019/5/21.
 */

/**
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * s = "aaabb", k = 3
 * Output:
 * 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * 思路：acabbdd 2 从总次数小于k的字母处截断， 因为包含此字母一定不满足要求，所以此字母前后的子串不能相连，要跳过此字母
 */
public class LongestSubstring__ {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        // 每次递归都算出字母频率数组
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }

        // 如果子串有效，统计长度
        boolean flag = true;
        for(int i = 0; i < counts.length; i++){
            if(counts[i] > 0 && counts[i] < k){
                flag = false;
            }
        }
        if(flag){
            return s.length();
        }

        // 如果子串无效，则从总次数小于k的字母处截断
        int result = 0;
        int start = 0;
        int cur = 0;
        while(cur < s.length()){
            // 若字母剩余总次数小于k 跳过该字母
            if(counts[s.charAt(cur) - 'a'] < k){
                //substring方法endIndex参数是不包含的 即跳过剩余总次数小于k的字母
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
