package dp_greedy; /**
 * created by Zheng Jiateng on 2019/5/30.
 */

/**
 * 198. House Robber
 *
 * 思路：dp典型题
 * dp[i]为考虑到i为止的最高金额 有两种情况 抢i和不抢i 与背包问题很类似
 * 让dp的索引比nums大1，设dp[0]=0，避免对边界条件的考虑
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1]; // dp[i]为考虑到i为止的最高金额 有两种情况 抢i和不抢i
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}
