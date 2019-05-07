/**
 * created by Zheng Jiateng on 2019/5/7.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number 手机按键
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * BFS FIFO的队列 先进队列的先处理
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.offer("");
        while(result.peek().length() != digits.length()){
            String remove = result.poll();
            String map = mapping[digits.charAt(remove.length()) - '2'];
            for(char ch : map.toCharArray()){
                result.offer(remove + ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println("abc".charAt(1));
//        System.out.println('2' - '0');
//        System.out.println("avc".length());
        System.out.println("abc".length());
        "abc".toCharArray();
        int[] a = {1, 2, 3};
        System.out.println(a.length);
        List<String> list = new ArrayList<>();
        list.size();
    }
}
