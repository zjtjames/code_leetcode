package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Zheng Jiateng on 2019/5/16.
 */

/**
 * 回文分割 131. Palindrome Partitioning 把字符串分割成若干个子字符串，使得每一个子串都是回文
 * 与子串问题和排列问题不同，回文分割必须包含所有元素；且先后次序不能变
 * Input: "aab"
 * Output:[["aa","b"],["a","a","b"]]
 *
 * 注意深复制
 */

public class PalindromePartition__ {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() < 1) return result;
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(String s, List<String> list, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    list.add(s.substring(start, i + 1));
                    backtrack(s, list, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}
