/**
 * Created by Zheng Jiateng on 2019/6/28.
 */

import java.util.HashMap;

/**
 * 1. Two Sum
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 思路：one-pass HashMap 一边加一边查看已有的map
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // map的key为数组的值，value为数组的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
