/**
 * created by Zheng Jiateng on 2019/8/17.
 */
package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的连续子数组的个数
 * eg: 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 思路: sum为前缀和 即当前数字（含）之前所有数字的和
 * nums[1] + nums[2] = sum[2] - sum[0]
 * 用一个map存当前数字之前前缀和为key的个频率
 * 这样可以时间、空间都是o(n)
 */
public class SubarraySum__ {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0; // 前缀和
        Map<Integer, Integer> map = new HashMap<>(); // key前缀和 value为当前数字之前前缀和为key的个频率
        map.put(0, 1); // 防止漏掉数组的前缀和刚好等于k的情况
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)) result += map.get(sum - k);
            if(!map.containsKey(sum)) map.put(sum, 1);
            else map.put(sum, map.get(sum) + 1);
        }
        return result;
    }
}
