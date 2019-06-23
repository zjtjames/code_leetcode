/**
 * created by Zheng Jiateng on 2019/6/23.
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 179. Largest Number
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String result = "";
        if (nums == null || nums.length < 1) return result;
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1); // 降序
            }
        });
        if (strings.get(0) == "0") return "0";
        for (String str : strings) result += str;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
        }
        System.out.println(strings.get(0) == "0");
    }
}
