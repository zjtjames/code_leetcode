package dp_greedy; /**
 * created by Zheng Jiateng on 2019/5/29.
 */

/**
 * 70. Climbing Stairs
 *
 * 思路：dp
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < n + 1; i++){
            if(i == 1) {
                dp[i] = 1;
            }else if(i == 2) {
                dp[i] = 2;
            } else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
