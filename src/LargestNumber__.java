/**
 * created by Zheng Jiateng on 2019/6/23.
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 179. Largest Number
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * 思路： 用o1+o2与o2+o1 compareTo是精髓
 */
public class LargestNumber__ {
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
        if (strings.get(0).equals("0")) return "0";
        for (String str : strings) result += str;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
            integers.add(num);
        }
        System.out.println(strings.get(0) == "0");
        System.out.println("00".compareTo("1"));
        System.out.println(integers.get(0) == 0);
    }
}
