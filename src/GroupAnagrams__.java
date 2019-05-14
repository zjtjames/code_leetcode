/**
 * created by Zheng Jiateng on 2019/5/14.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 49. Group Anagrams   Given an array of strings, group anagrams together.
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [["ate","eat","tea"], ["nat","tan"], ["bat"]]
 *
 * 能在一组的一定是26个字母频次相同的   把26个字母频次转换为String作为map的key
 * 此题重点学习语法
 */
public class GroupAnagrams__ {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> result = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < 26; i++){
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(1);
        System.out.println(set1.equals(set2));
        StringBuffer sb = new StringBuffer();
        sb.append(111);
        System.out.println(sb.toString());
    }
}
