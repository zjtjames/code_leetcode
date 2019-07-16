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
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    // 回文分割问题类似子集问题，因为可以不从头开始截断 所以要加一个start指针；而排列就不需要这个指针
    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(tempList)); // 万分注意 此处一定要用深复制 否则因为回溯 tempList的元素都被删掉了 最后result里全是空list
        }else {
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(result, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi){
        while(lo < hi){
            if(s.charAt(lo++) != s.charAt(hi--)){
                return false;
            }
        }
        return true;
    }

}
