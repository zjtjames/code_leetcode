/**
 * created by Zheng Jiateng on 2019/8/22.
 */
package dp_greedy;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * 所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的
 *
 * 思路: 因为首尾不能都抢 所以分两种情况 抢第一家和不抢第一家
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        //因为首尾不能都抢 所以分两种情况 抢第一家和不抢第一家
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int robFirst = core(Arrays.copyOfRange(nums, 0, len - 1));
        int notRobFirst = core(Arrays.copyOfRange(nums, 1, len));
        return Math.max(robFirst, notRobFirst);
    }

    private int core(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}
