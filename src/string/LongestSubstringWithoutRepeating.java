package string; /**
 * Created by Zheng Jiateng on 2019/7/4.
 */

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters 无重复字符的最长子串
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s.length() < 1) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        int lo= 0;
        int hi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                hi++;
                result = Math.max(result, hi - lo);
            } else {
                int cur = map.get(s.charAt(i));
                while (lo <= cur) {
                    map.remove(s.charAt(lo));
                    lo++;
                }
                map.put(s.charAt(i), i);
                hi++;
                result = Math.max(result, hi - lo);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
