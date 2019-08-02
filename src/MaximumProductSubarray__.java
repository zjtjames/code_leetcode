/**
 * created by Zheng Jiateng on 2019/6/20.
 */

/**
 * 152. Maximum Product Subarray 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 要点： 同时存包含第i个元素的最大乘积和最小乘积 遇到负数 最大乘积和最小乘积互换
 */
public class MaximumProductSubarray__ {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int iMax = nums[0]; // 包含第i个元素的最大乘积
        int iMin = nums[0]; // 包含第i个元素的最小乘积
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(nums[i], iMax * nums[i]);
            iMin = Math.min(nums[i], iMin * nums[i]);
            result = Math.max(result, iMax);
        }
        return result;
    }
}
