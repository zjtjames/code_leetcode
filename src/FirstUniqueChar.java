/**
 * created by Zheng Jiateng on 2019/7/1.
 */

import java.util.HashMap;

/**
 * 387. First Unique Character in a String
 */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 1);
            else {
                map.put(c, map.get(c) + 1);
            }
        }

        for(int i = 0; i < len; i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
