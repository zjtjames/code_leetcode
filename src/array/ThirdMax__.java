/**
 * created by Zheng Jiateng on 2019/8/20.
 */
package array;

/**
 * 414. 第三大的数 去重
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。存在两个值为2的数，它们都排第二。
 *
 * 思路：用null来判断是否有第三大的数
 */
public class ThirdMax__ {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for(Integer num : nums){
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue; // 遇到重复直接跳过
            if(max1 == null || num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(max2 == null || num > max2){
                max3 = max2;
                max2 = num;
            } else if(max3 == null || num > max3){
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3; // 用null来判断是否有第三大的数
    }
}
