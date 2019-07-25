package dp_greedy; /**
 * created by Zheng Jiateng on 2019/6/20.
 */

/**
 * 322. Coin Change
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * 思路：典型dp题
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(len < 1) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < len; j++){
                if(i - coins[j] >= 0){
                    if(dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
