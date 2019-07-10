/**
 * created by Zheng Jiateng on 2019/7/10.
 */

/**
 * 242. Valid Anagram
 * 字母异位词
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 思路：26维数组记录每个字母出现频次
 */
public class IsAnagram__ {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }
        return true;
    }
}
