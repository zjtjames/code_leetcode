/**
 * created by Zheng Jiateng on 2019/7/10.
 */

import java.util.HashMap;

/**
 * 13. Roman to Integer
 * 罗马数字转整型
 *
 * 思路：如果当前数字比后一个数字小 则总和要减去当前数字 如IV = -1+5=4
 */
public class RomanToInt__ {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int result = 0;
        for(int i = 0; i < s.length() - 1; i++){
            int num = map.get(s.charAt(i));
            int nextNum = map.get(s.charAt(i + 1));
            if(num >= nextNum) result += num;
            else result -= num; // 这一行是核心
        }
        result += map.get(s.charAt(s.length() - 1));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
