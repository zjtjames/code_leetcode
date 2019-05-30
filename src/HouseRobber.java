/**
 * created by Zheng Jiateng on 2019/5/30.
 */

/**
 * 198. House Robber
 *
 * 思路：dp典型题
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        // dp[i]为包含i的到i为止的最大收入 dp[i]不是result[i]
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for(int i = 3; i < len; i++){
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        // 最大收入为dp[len - 1]与dp[len - 2]中较大的一个
        return Math.max(dp[len - 1], dp[len - 2]);
    }
}
