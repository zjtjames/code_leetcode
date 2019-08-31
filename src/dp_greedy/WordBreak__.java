package dp_greedy; /**
 * created by Zheng Jiateng on 2019/6/11.
 */

import java.util.List;

/**
 * 139. Word Break
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * 思路：dp 第二个单词的起点的前一个字母的dp标记必须是true 即之前的字母必须组成单词
 */
public class WordBreak__ {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                // 这个dp[j]是关键
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
