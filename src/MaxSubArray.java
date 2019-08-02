/**
 * created by Zheng Jiateng on 2019/5/29.
 */

/**
 * 53. Maximum Subarray
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 思路：最大子列和 在线处理
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSub = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            maxSub = Math.max(maxSub, sum);
            if(sum <= 0) {
                sum = 0;
            }
        }
        return maxSub;
    }
}
